package com.Ugams.core.config;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "API OSGi Config",
        description = "api osgi config")

public @interface ApiConfig {
    @AttributeDefinition(
            name = "Single user Api",
            description = "single user api",
            type = AttributeType.STRING)
    public String singleuserapi() default "https://reqres.in/api/users/";
    @AttributeDefinition(
            name = "Multi user Api",
            description = "multi user api",
            type = AttributeType.STRING)
    public String multiuserapi() default "https://reqres.in/api/users?page=";
}



