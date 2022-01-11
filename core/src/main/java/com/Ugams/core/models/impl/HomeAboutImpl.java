package com.Ugams.core.models.impl;

import com.Ugams.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class HomeAboutImpl implements HomeAbout{

     protected static final String RESOURCE_TYPE="ugams/components/content/home-about";

    @Inject
    String title;

    @Inject
    String desc;

    @Inject
    String heading;

    @Inject
    String buttonTitle;

    @Inject
    String img;

    @Inject
    String path;

    @Override
    public String getHomeAboutTitle() {
        return title;
    }

    @Override
    public String getHomeAboutHeading() {
        return heading;
    }

    @Override
    public String getHomeAboutDescription() {
        return desc;
    }
    @Override
    public String getHomeAboutButtonTitle() {
        return buttonTitle;
    }

    @Override
    public String getImg() {
        return img;
    }
    @Override
    public String getPathValue() {
        return path;
    }


}
