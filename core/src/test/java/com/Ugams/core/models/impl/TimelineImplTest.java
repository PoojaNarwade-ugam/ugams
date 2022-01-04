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

        Resource json = aemContext.currentResource("/content/timelines");
        Timeline timeline = json.adaptTo(Timeline.class);
        assertNotNull(timeline.getTimelineDetails());
        assertEquals("Masters in Graphics & Fine Arts", timeline.getTimelineDetails().get(0).get("title"));
        assertEquals("Session: 2010-11", timeline.getTimelineDetails().get(0).get("text1"));
        assertEquals("Result: 3.78 (In the Scale of 4.00)", timeline.getTimelineDetails().get(0).get("text2"));
    }
}