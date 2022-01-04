package com.Ugams.core.models.impl;
import com.Ugams.core.config.UgamsCaconfig;
import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CaconfigImplTest {
        AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
        CaconfigImpl caconfig;
        Page currentPage;
        ResourceResolver resourceResolver = mock(ResourceResolver.class);
        Resource contentResource = mock(Resource.class);
        ConfigurationBuilder configurationBuilder = mock(ConfigurationBuilder.class);
        private String siteCountry;
        private String siteAdmin;
        private String siteSection;
        private String siteLocale;

        @BeforeEach
        void setUp() throws NoSuchFieldException {
            caconfig = aemContext.registerService(new CaconfigImpl());
            UgamsCaconfig caConfig = mock(UgamsCaconfig.class);
            lenient().when(caConfig.siteAdmin()).thenReturn("Ugams User1");
            lenient().when(caConfig.siteCountry()).thenReturn("Us");
            lenient().when(caConfig.siteSection()).thenReturn("Site Section");
            lenient().when(caConfig.siteLocale()).thenReturn("English");
            currentPage = aemContext.create().page("/content/ugams/us/en");
            String currentPath = "/content/ugams/us/en";
            PrivateAccessor.setField(caconfig, "currentPage", currentPage);
            PrivateAccessor.setField(caconfig, "resourceResolver", resourceResolver);
            when(resourceResolver.getResource(currentPath)).thenReturn(contentResource);
            when(contentResource.adaptTo(ConfigurationBuilder.class)).thenReturn(configurationBuilder);
            when(configurationBuilder.as(UgamsCaconfig.class)).thenReturn(caConfig);
            caconfig.postConstruct();
        }
        @Test
        void getSiteCountry() {
            assertEquals("Us", caconfig.getSiteCountry());
        }

        @Test
        void getSiteAdmin() {
            assertEquals("Ugams User1", caconfig.getSiteAdmin());
        }

        @Test
        void getSiteSection() {
            assertEquals("Site Section", caconfig.getSiteSection());
        }

       @Test
        void getSiteLocale() {
        assertEquals("English", caconfig.getSiteLocale());
    }
      }

