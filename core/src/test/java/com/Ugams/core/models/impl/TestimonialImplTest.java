package com.Ugams.core.models.impl;

import com.Ugams.core.models.Portfolio;
import com.Ugams.core.models.Testimonial;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TestimonialImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {

        aemContext.load().json("/testimonial.json","/content");
    }

    @Test
    void getTestimonialName() {
        Resource resource = aemContext.currentResource("/content/testimonial");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("Harriet Maxwell", testimonial.getTestimonialName());
    }

    @Test
    void getTestimonialDescription() {
        Resource resource = aemContext.currentResource("/content/testimonial");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills, the bigger the payoff you.", testimonial.getTestimonialDescription());
    }

    @Test
    void getTestimonialDesignation() {
        Resource resource = aemContext.currentResource("/content/testimonial");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("CEO at Google", testimonial.getTestimonialDesignation());
    }


}