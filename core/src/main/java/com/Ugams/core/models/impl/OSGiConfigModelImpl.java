package com.Ugams.core.models.impl;


import com.Ugams.core.models.OSGiConfigModel;
import com.Ugams.core.services.OSGiConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGiConfigModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGiConfigModelImpl implements OSGiConfigModel {
    @OSGiService
    OSGiConfig oSGiConfig;

    @Override
    public String getServiceName() {
        return oSGiConfig.getServiceName();
    }

    @Override
    public int getServiceCount() {
        return oSGiConfig.getServiceCount();
    }

}

