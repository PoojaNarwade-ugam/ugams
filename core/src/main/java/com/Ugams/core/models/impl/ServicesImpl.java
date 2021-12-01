package com.Ugams.core.models.impl;


import com.Ugams.core.models.Services;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Services.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServicesImpl implements Services {


    @Inject
    String title;

    @Inject
    String text;


    @Override
    public String getServiceTitle() {
        return title;
    }

    @Override
    public String getServiceText() {
        return text;
    }
}
