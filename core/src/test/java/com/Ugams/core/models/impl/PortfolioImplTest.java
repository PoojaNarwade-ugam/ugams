package com.Ugams.core.models.impl;

import com.Ugams.core.models.HomeAbout;
import com.Ugams.core.models.Portfolio;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PortfolioImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/portfolio.json","/content");
    }

    @Test
    void getPortfolioTitle() {
        Resource resource = aemContext.currentResource("/content/portfolio");
       Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("2D Vinyl Design", portfolio.getPortfolioTitle());
    }

    @Test
    void getPortfolioText() {
        Resource resource = aemContext.currentResource("/content/portfolio");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("Vector", portfolio.getPortfolioText());
    }

    @Test
    void getImg() {
        Resource resource = aemContext.currentResource("/content/portfolio");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("/content/dam/ugams/p1.jpg", portfolio.getImg());
    }

    @Test
    void getPreimg() {
        Resource resource = aemContext.currentResource("/content/portfolio");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("/content/dam/ugams/preview.png", portfolio.getPreimg());
    }
}