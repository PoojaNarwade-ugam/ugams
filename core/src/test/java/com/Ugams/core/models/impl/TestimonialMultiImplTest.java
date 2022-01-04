package com.Ugams.core.models.impl;

import com.Ugams.core.models.TestimonialMulti;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TestimonialMultiImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/testmulti.json","/content");
    }

    @Test
    void getTestimonialDetails() {
        Resource json = aemContext.currentResource("/content/testmulti");
        TestimonialMulti testimonialMulti= json.adaptTo(TestimonialMulti.class);
        assertEquals("Harriet Maxwell", testimonialMulti.getTestimonialDetails().get(0).get("name"));
        assertEquals("CEO at Google", testimonialMulti.getTestimonialDetails().get(0).get("desg"));
        assertEquals("Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills, the bigger the payoff you.", testimonialMulti.getTestimonialDetails().get(0).get("desc"));
    }
}