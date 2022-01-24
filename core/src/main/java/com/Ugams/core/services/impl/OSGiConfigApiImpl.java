package com.Ugams.core.services.impl;

import com.Ugams.core.config.ApiConfig;
import com.Ugams.core.services.OSGiConfigApi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = OSGiConfigApi.class,immediate = true)
@Designate(ocd = ApiConfig.class)
public class OSGiConfigApiImpl implements OSGiConfigApi {
    private static final Logger log = LoggerFactory.getLogger(OSGiConfigApiImpl.class);
    private String single;
    private String multi;
    @Activate
    protected void activate(ApiConfig apiConfig) {
        single = apiConfig.singleuserapi();
        multi = apiConfig.multiuserapi();
    }

    @Override
    public String getSingleUserApi(){
        log.info("in singleuser"+single);
        return single;
    }

    @Override
    public String getMultiUserApi(){
        log.info("in multiuser"+multi);
        return multi;
    }
}

