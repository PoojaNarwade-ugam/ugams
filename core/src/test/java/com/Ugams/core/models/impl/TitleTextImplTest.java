package com.Ugams.core.models.impl;

import com.Ugams.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TitleTextImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/titletext.json","/content");
    }

    @Test
    void getTitle() {
        Resource resource = aemContext.currentResource("/content/titletext");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals("My Offered Services", titleText.getTitle());
    }

    @Test
    void getText() {
        Resource resource = aemContext.currentResource("/content/titletext");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals("At about this time of year, some months after New Year’s resolutions have been made and kept, or made and neglected.", titleText.getText());
    }

    @Test
    void getSectionGap() {
        Resource resource = aemContext.currentResource("/content/titletext");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals(true, titleText.getSectionGap());
    }

    @Test
    void getBottomPadding() {
        Resource resource = aemContext.currentResource("/content/titletext");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals(false, titleText.getBottomPadding());
    }

    @Test
    void getBackground() {
        Resource resource = aemContext.currentResource("/content/titletext");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals(false, titleText.getBackground());
    }
}