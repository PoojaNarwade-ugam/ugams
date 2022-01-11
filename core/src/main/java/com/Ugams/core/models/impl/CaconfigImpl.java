package com.Ugams.core.models.impl;
import com.Ugams.core.config.UgamsCaconfig;
import com.Ugams.core.models.Caconfig;
import com.day.cq.wcm.api.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Caconfig.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CaconfigImpl implements Caconfig {
    @SlingObject
    ResourceResolver resourceResolver;
    @ScriptVariable
    Page currentPage;
    private String siteCountry;
    private String siteAdmin;
    private String siteSection;
    private String siteLocale;

    @Override
    public String getSiteCountry() {
        return siteCountry;
    }

    @Override
    public String getSiteAdmin() {
        return siteAdmin;
    }

    @Override
    public String getSiteSection() {
        return siteSection;
    }
    @Override
    public String getSiteLocale() {
        return siteLocale;
    }

    @PostConstruct
    public void postConstruct() {
        UgamsCaconfig caConfig = getContextAwareConfig(currentPage.getPath(), resourceResolver);
        siteCountry = caConfig.siteCountry();
        siteAdmin = caConfig.siteAdmin();
        siteSection = caConfig.siteSection();
        siteLocale =caConfig.siteLocale();
    }
    public UgamsCaconfig getContextAwareConfig(String currentPage, ResourceResolver resourceResolver) {
        String currentPath = StringUtils.isNoneBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null) {
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(UgamsCaconfig.class);}}return null;}}
