package com.Ugams.core.services.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class OSGiConfigImplTest {
    private final AemContext aemContext = new AemContext();
    OSGiConfigImpl osGiConfig;
    @BeforeEach
    void setUp() {
        osGiConfig=aemContext.registerService(new OSGiConfigImpl());
        OSGiConfigImpl.ServiceConfig config=mock(OSGiConfigImpl.ServiceConfig.class);
        when(config.serviceName()).thenReturn("UGAMS Service");
        when(config.getServiceCount()).thenReturn(12);
        osGiConfig.activate(config);
    }



    @Test
    void getServiceName() {
        assertEquals("UGAMS Service", osGiConfig.getServiceName());
    }

    @Test
    void getServiceCount() {
        assertEquals(12, osGiConfig.getServiceCount());
    }
}