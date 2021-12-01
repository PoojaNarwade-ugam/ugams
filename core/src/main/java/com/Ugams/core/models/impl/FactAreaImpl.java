package com.Ugams.core.models.impl;


import com.Ugams.core.models.FactArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = FactArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FactAreaImpl implements FactArea{


    @ChildResource
    Resource factareamultifield;

    @Override
    public List<Map<String, String>> getFactAreaDetails() {
        List<Map<String, String>> factAreaMap = new ArrayList<>();
            if (factareamultifield != null) {
                for (Resource fact : factareamultifield.getChildren()) {
                    Map<String, String> factMap = new HashMap<>();
                    factMap.put("factNumber", fact.getValueMap().get("factNumber", String.class));
                    factMap.put("factText", fact.getValueMap().get("factText", String.class));
                    factAreaMap.add(factMap);
                }
            }
        return factAreaMap;
    }

}
