package com.Ugams.core.workflow;

import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.metadata.MetaDataMap;
import com.day.cq.workflow.metadata.SimpleMetaDataMap;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.jcr.Session;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UgamsWorkflowStepTest {
    @Mock
    private WorkflowSession workflowSession;

    @Mock
    private WorkItem workItem;

    @Mock
    private Session session;
    @Mock
    private Process process;


    @Mock
    private ResourceResolver resourceResolver;
    @Mock
    protected ResourceResolverFactory resourceResolverFactory;
    private static final String WCM_PAYLOAD_PATH = "/jcr:content";


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(workflowSession.getSession()).thenReturn(session);
        when(resourceResolverFactory.getResourceResolver(any(Map.class))).thenReturn(resourceResolver);

    }

    @Test
    void execute() {
        WorkflowData workflowData = mock(WorkflowData.class);
        when(workItem.getWorkflowData()).thenReturn(workflowData);
        when(workflowData.getPayloadType()).thenReturn("JCR_PATH");
        MetaDataMap metaData = new SimpleMetaDataMap();
        metaData.put("PROCESS_ARGS", "");


    }
}