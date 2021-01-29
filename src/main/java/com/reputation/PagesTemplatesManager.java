package com.reputation;

import com.reputation.common.spring.RdcApplication;
import com.reputation.pages.templates.config.PagesTemplateConfig;
import com.reputation.pages.templates.config.PagesTemplateManagementServerConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class PagesTemplatesManager {
    public static void main(String[] args) {
        RdcApplication.run(
                new SpringApplicationBuilder()
                        .bannerMode(Banner.Mode.OFF)
                        .sources(PagesTemplateConfig.class, PagesTemplateManagementServerConfig.class),
                args);
    }
}
