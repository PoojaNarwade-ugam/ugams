package com.Ugams.core.models.impl;

import com.Ugams.core.models.BannerArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerAreaImplTest {

    private final AemContext aemContext = new AemContext();

    private BannerArea bannerArea;

    @BeforeEach
    void setUp() {

        aemContext.load().json("/bannerarea.json","/content");

    }

    @Test
    void getBannerAreaTitle() {

        Resource resource = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = resource.adaptTo(BannerArea.class);
        assertEquals("THIS IS ME", bannerArea.getBannerAreaTitle());
    }


    @Test
    void getBannerAreaHeading() {
        Resource resource = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = resource.adaptTo(BannerArea.class);
        assertEquals("PHILIP GILBERT", bannerArea.getBannerAreaHeading());
    }

    @Test
    void getBannerAreaDescription() {
        Resource resource = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = resource.adaptTo(BannerArea.class);
        assertEquals("You will begin to realise why", bannerArea.getBannerAreaDescription());
    }

    @Test
    void getBannerAreaButtonTitle() {
        Resource resource = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = resource.adaptTo(BannerArea.class);
        assertEquals("DISCOVER NOW", bannerArea.getBannerAreaButtonTitle());
    }

    @Test
    void getImg() {
        Resource resource = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = resource.adaptTo(BannerArea.class);
        assertEquals("/content/dam/ugams/hero-img.png", bannerArea.getImg());
    }

    @Test
    void getPathValue() {
        Resource resource = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = resource.adaptTo(BannerArea.class);
        assertEquals("/content/ugams/us/en/about", bannerArea.getPathValue());
    }
}