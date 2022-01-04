package com.Ugams.core.models.impl;

import com.Ugams.core.models.Blog;
import com.Ugams.core.models.Services;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BlogImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/Blog.json","/content");
    }

    @Test
    void getBlogTitle() {
        Resource resource = aemContext.currentResource("/content/Blog");
        Blog blog = resource.adaptTo(Blog.class);
        assertEquals("Break Through Self Doubt And Fear", blog.getBlogTitle());
    }

    @Test
    void getBlogText() {
        Resource resource = aemContext.currentResource("/content/Blog");
        Blog blog = resource.adaptTo(Blog.class);
        assertEquals("Dream interpretation has many forms; it can be done be done for the sake of fun, hobby or can be taken up as a serious career.", blog.getBlogText());
    }

    @Test
    void getImg() {
        Resource resource = aemContext.currentResource("/content/Blog");
        Blog blog = resource.adaptTo(Blog.class);
        assertEquals("/content/dam/ugams/b1.jpg", blog.getImg());
    }
}