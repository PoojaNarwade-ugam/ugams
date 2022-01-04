package com.Ugams.core.models.impl;

import com.Ugams.core.models.OSGiConfigModel;
import com.Ugams.core.services.impl.OSGiConfigImpl;
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
class OSGiConfigModelImplTest {
    AemContext aemContext = new AemContext();
    OSGiConfigImpl osgiConfig;
    private String serviceName;
    private int serviceCount;

    @BeforeEach
    void setUp() throws NoSuchFieldException{
        osgiConfig=aemContext.registerService(new OSGiConfigImpl());
        OSGiConfigImpl.ServiceConfig config = mock(OSGiConfigImpl.ServiceConfig.class);
        when(config.serviceName()).thenReturn("UGAMS Service");
        when(config.getServiceCount()).thenReturn(12);
        osgiConfig.activate(config);
    }

    @Test
    void getServiceName() {
        OSGiConfigModel osGiConfigModel = aemContext.request().adaptTo(OSGiConfigModel.class);
        assertEquals("UGAMS Service", osGiConfigModel.getServiceName());
    }

    @Test
    void getServiceCount() {
        OSGiConfigModel osGiConfigModel = aemContext.request().adaptTo(OSGiConfigModel.class);
        assertEquals(12,osGiConfigModel.getServiceCount());
    }
}