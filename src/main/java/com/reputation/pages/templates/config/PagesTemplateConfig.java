package com.reputation.pages.templates.config;

import com.reputation.common.config.ServiceRegistryConfig;
import com.reputation.dao.mongo.spring.DefaultMongoConfig;
import com.reputation.web.config.ManagementServerPropertiesConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        value = {
                DefaultMongoConfig.class,
                ServiceRegistryConfig.class,
                ManagementServerPropertiesConfig.class
        })
@EnableAutoConfiguration(
        exclude = { MongoDataAutoConfiguration.class })
@ComponentScan(
        basePackages = { "com.reputation.pages.templates.*" })
public class PagesTemplateConfig {
}
