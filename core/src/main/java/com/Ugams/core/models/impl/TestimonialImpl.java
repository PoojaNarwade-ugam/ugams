package com.Ugams.core.models.impl;



import com.Ugams.core.models.Testimonial;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        resourceType = TestimonialImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions ="json",selector = "testimonial",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        })
@JsonRootName("Testimonial")
public class TestimonialImpl implements Testimonial{

    final protected static String RESOURCE_TYPE="ugams/components/content/testimonial";

    @Inject
    String name;

    @Inject
    String desc;

    @Inject
    String desg;

    @JsonProperty(value = "Name")
    @Override
    public String getTestimonialName() {
        return name;
    }

    @JsonProperty(value = "Description")
    @Override
    public String getTestimonialDescription() {
        return desc;
    }

    @JsonProperty(value = "Designation")
    @Override
    public String getTestimonialDesignation() {
        return desg;
    }

    @JsonProperty(value = "Component Name")
    public String ComponentName(){
        return "Testimonial";
    }
}
