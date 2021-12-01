package com.Ugams.core.models.impl;


import com.Ugams.core.models.Timeline;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = Timeline.class,
        resourceType = TimelineImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions ="json",selector = "timeline",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        })
@JsonRootName("Timeline")
public class TimelineImpl implements Timeline{

    final protected static String RESOURCE_TYPE="ugams/components/content/timeline";


    @ChildResource
    Resource timeline;

    @JsonProperty(value = "Component Name")
    public String ComponentName(){
        return "Timeline";
    }

    @Override
    public List<Map<String, String>> getTimelineDetails() {
        List<Map<String, String>> timelineMap = new ArrayList<>();
        if (timeline != null) {
            for (Resource fact : timeline.getChildren()) {
                Map<String, String> tMap = new HashMap<>();
                tMap.put("title", fact.getValueMap().get("title", String.class));
                tMap.put("text1", fact.getValueMap().get("text1", String.class));
                tMap.put("text2", fact.getValueMap().get("text2", String.class));
                timelineMap.add(tMap);
            }
        }
        return timelineMap;
    }
}
