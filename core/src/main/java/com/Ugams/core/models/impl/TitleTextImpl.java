package com.Ugams.core.models.impl;


import com.Ugams.core.models.TitleText;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = TitleText.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleTextImpl implements TitleText{

    @Inject
    String title;

    @Inject
    String text;

    @Inject
    boolean sectionGap;

    @Inject
    boolean bottomPadding;

    @Inject
    boolean background;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean getSectionGap() {
        return sectionGap;
    }

    @Override
    public boolean getBottomPadding() {
        return bottomPadding;
    }

    @Override
    public boolean getBackground() {
        return background;
    }
}
