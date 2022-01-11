package com.Ugams.core.services.impl;
import com.Ugams.core.services.DemoService;
import com.day.cq.commons.date.DateUtil;
import com.Ugams.core.utils.ResolverUtils;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Node;
import javax.jcr.Session;
import java.util.Calendar;
@Component(service = DemoService.class,immediate = true)
public class DemoServiceImpl implements DemoService {
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Override
    public void addProperty(String path){
        try{

            Session session;
            Resource resource;
            try (ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)) {
                session = serviceResourceResolver.adaptTo(Session.class);
                resource = serviceResourceResolver.getResource("/content/ugams/us/en/demo/jcr:content/root/democomp");
            }
            Node node = resource.adaptTo(Node.class);
            node.setProperty("Time" , DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())));
            session.save();
            session.logout();
        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }

}

