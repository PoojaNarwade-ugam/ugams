package com.Ugams.core.models.impl;


import com.Ugams.core.models.ServiceUserModel;
import com.Ugams.core.utils.ResolverUtils;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceUserModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ServiceUserModelImpl implements ServiceUserModel {

    @OSGiService
    ResourceResolverFactory resourceResolverFactory;
    @Inject
    private QueryBuilder queryBuilder;
    String user = " ";
    final Logger log = LoggerFactory.getLogger(ServiceUserModelImpl.class);
    @Override
    public String getUsernames() {

        log.info("\n Inside Getusername of service ");

        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try {
            Session session;
            try (ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)) {
                session = serviceResourceResolver.adaptTo(Session.class);
            }
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> hits = result.getHits();
            for (Hit hit : hits) {
                user = user + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }} catch (RepositoryException | LoginException e) {
            log.info("\n outside Getusername of service ");
           }
        return user;
    }
}