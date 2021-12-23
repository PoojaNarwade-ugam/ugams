package com.Ugams.core.models.impl;

import com.Ugams.core.services.DemoService;
import com.Ugams.core.utils.ResolverUtils;


import com.day.cq.commons.date.DateUtil;
import com.day.cq.commons.date.InvalidDateException;
import com.day.cq.replication.*;
import java.util.Calendar;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;


@Component(immediate = true)

public class DempPreprocessor implements Preprocessor {
    private static final Logger log = LoggerFactory.getLogger(DempPreprocessor.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    @Reference
    DemoService currentTime;
   String mypath="/content/ugams/us/en/demo/jcr:content/root/democomp";

    @Override
    public void preprocess(final ReplicationAction replicationAction,
                           final ReplicationOptions replicationOptions) throws ReplicationException {

        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {

            return;
        }
        String path = replicationAction.getPath();
        if(path.equals("/content/ugams/us/en/demo")){
            log.debug("path equal");


            try{
                log.debug("inside try");
                ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
                Session session = serviceResourceResolver.adaptTo(Session.class);

                Resource resource = serviceResourceResolver.getResource("/content/ugams/us/en/demo/jcr:content/root/democomp");
                Node node = resource.adaptTo(Node.class);


                //Calendar currentTime=DateUtil.parseISO8601(DateUtil.getISO8601Date(java.util.Calendar.getInstance()));

                if (node.getProperty("Time") == DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance()))) {
                    log.debug("Entered if");

                } else {
                    log.debug("Entered else");
                    node.setProperty("Time", DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())));
                    currentTime.addProperty(mypath);
                    session.save();
                    session.logout();
                }
            }
            catch (RepositoryException | InvalidDateException | LoginException e) {
                e.printStackTrace();

            }

        }

        try {
            log.debug(path);
        }
        catch (Exception e) {

            log.debug(e.getMessage());
        }
    }
}


