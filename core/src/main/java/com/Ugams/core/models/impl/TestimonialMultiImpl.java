package com.Ugams.core.models.impl;


import com.Ugams.core.models.TestimonialMulti;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = TestimonialMulti.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class TestimonialMultiImpl implements TestimonialMulti{

    @ChildResource
    Resource testimonialmultifield;

    @Override
    public List<Map<String, String>> getTestimonialDetails() {
        List<Map<String, String>> testimonialMap = new ArrayList<>();
        if (testimonialmultifield != null) {
            for (Resource test : testimonialmultifield.getChildren()) {
                Map<String, String> testMap = new HashMap<>();
                testMap.put("name", test.getValueMap().get("name", String.class));
                testMap.put("desc", test.getValueMap().get("desc", String.class));
                testMap.put("desg", test.getValueMap().get("desg", String.class));
                testimonialMap.add(testMap);
            }
        }
        return testimonialMap;
    }
}
