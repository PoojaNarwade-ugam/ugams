package com.Ugams.core.models.impl;


import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;


import java.io.IOException;

import java.util.HashMap;
import java.util.Map;



import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class AdditionServletTest {


    AdditionServlet additionservlet = new AdditionServlet();

    @BeforeEach
    void setUp() {

    }

    @Test
    void doGet(AemContext aemContext) throws IOException {

        MockSlingHttpServletRequest mockSlingRequest = aemContext.request();
        MockSlingHttpServletResponse mockSlingResponse = aemContext.response();
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("num1", 10);
        parameterMap.put("num2", 10);
        mockSlingRequest.setParameterMap(parameterMap);
        additionservlet.doGet(mockSlingRequest,mockSlingResponse);
        assertEquals(20,Integer.parseInt(mockSlingResponse.getOutputAsString()));

    }
}