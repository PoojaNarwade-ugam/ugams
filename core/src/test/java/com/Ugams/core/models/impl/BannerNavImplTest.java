package com.Ugams.core.models.impl;

import com.Ugams.core.models.BannerArea;
import com.Ugams.core.models.BannerNav;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerNavImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/bannernav.json","/content");
    }

    @Test
    void getTitle() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("Services", bannerNav.getTitle());
    }

    @Test
    void getNav1() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("Home", bannerNav.getNav1());
    }

    @Test
    void getNav2() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("Services", bannerNav.getNav2());
    }

    @Test
    void getNav1Path() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("/content/ugams/us/en/home", bannerNav.getNav1Path());
    }

    @Test
    void getNav2Path() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("null", bannerNav.getNav2Path());
    }
}