package com.Ugams.core.utils;


import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import java.util.HashMap;
import java.util.Map;

public class ResolverUtils {

    public static final String UGAM_SERVICE_USER = "ugamserviceuser";

    public static ResourceResolver newResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException {

        final Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE,UGAM_SERVICE_USER);
        ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
        return resolver;
    }
}
