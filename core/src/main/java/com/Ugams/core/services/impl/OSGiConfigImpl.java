package com.Ugams.core.services.impl;

import com.Ugams.core.services.OSGiConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = OSGiConfig.class,immediate = true)
@Designate(ocd = OSGiConfigImpl.ServiceConfig.class)
public class OSGiConfigImpl implements OSGiConfig {

    @ObjectClassDefinition(name="UGAMS OSGi Configuration",
            description ="OSGi Configuration")
    public @interface ServiceConfig {

        @AttributeDefinition(
                name = "Service Name",
                description = "Enter Service name",
                type = AttributeType.STRING)
        public String serviceName() default "UGAMS Service";

        @AttributeDefinition(
                name = "Service Count",
                description = "Add Service Count",
                type = AttributeType.INTEGER)
        int getServiceCount() default 8;
    }
    private String serviceName;
    private int serviceCount;

    @Activate
    protected void activate(ServiceConfig serviceConfig){
        serviceName=serviceConfig.serviceName();
        serviceCount=serviceConfig.getServiceCount();

    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
    @Override
    public int getServiceCount() {
        return serviceCount;
    }

}



