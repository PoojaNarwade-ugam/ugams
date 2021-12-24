package com.Ugams.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;
@Configuration(label="",description = "")
public @interface UgamsCaconfig {


    @Property(label = "siteCountry",
            description = "Site Name")
    String siteCountry() default "Us";
    @Property(label = "siteLocale",
            description = "Site Lang")
    String siteLocale() default "en";
    @Property(label = "siteAdmin",
            description = "Site Admin")
    String siteAdmin() default "admin";
    @Property(label = "siteSection",
            description = "Site Section")
    String siteSection() default "Ugams-aem";




}


