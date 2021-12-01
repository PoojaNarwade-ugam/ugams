package com.Ugams.core.models.impl;

import com.Ugams.core.models.HomeAbout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;

@Exporters({
        @Exporter(name = "jackson",extensions = "json",selector = "homeabout",
                options = {
                        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true")
                }),
        @Exporter(name = "homeabout",extensions = "xml",selector = "homeabout")
})
@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@JsonRootName("Home-About")
@XmlRootElement(name = "Home-About")
public class HomeAboutImpl implements HomeAbout{

    final protected static String RESOURCE_TYPE="ugams/components/content/home-about";

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

    @JsonProperty(value = "Description")
    @Override
    public String getHomeAboutDescription() {
        return desc;
    }

    @Override
    public String getHomeAboutButtonTitle() {
        return buttonTitle;
    }

    @JsonProperty(value = "Image Path")
    @Override
    public String getImg() {
        return img;
    }

    @Override
    public String getPathValue() {
        return path;
    }

    @JsonProperty(value = "Component Name")
    public String ComponentName(){
        return "Home About";
    }
}
