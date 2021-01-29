package com.reputation.pages.templates.config;

import com.reputation.common.thrift.ThriftServerConfig;
import com.reputation.cron.autoconfigure.CronConfig;
import com.reputation.assets.client.AssetsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Import({
        ThriftServerConfig.class,
        R4EPagesTemplateManagementClientConfig.class,
        CronConfig.class,
        AssetsClientConfig.class
})
@EnableScheduling
public class PagesTemplateManagementServerConfig {
}
