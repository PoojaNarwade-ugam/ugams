package com.Ugams.core.models.impl;

import com.Ugams.core.models.BannerArea;
import com.Ugams.core.models.Timeline;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junit.framework.Assert;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TimelineImplTest {

    private final AemContext aemContext = new AemContext();


    private Timeline timeline;


   @BeforeEach
    void setUp() {
       aemContext.load().json("/timeline.json","/content");
    }

    @Test
    void getTimelineDetails() {

        Resource json = aemContext.currentResource("/content/Timeline");
        Timeline timeline = json.adaptTo(Timeline.class);
        assertNotNull(timeline.getTimelineDetails());
    }
}