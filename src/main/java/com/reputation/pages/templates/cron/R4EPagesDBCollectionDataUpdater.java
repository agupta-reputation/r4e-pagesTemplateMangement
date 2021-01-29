package com.reputation.pages.templates.cron;

import com.reputation.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class R4EPagesDBCollectionDataUpdater {

    @Autowired
    private Cron cron;

    @Scheduled(
            cron = "${pages.template.updater.cron.regex}")
    public void updateMappingTables() {

    }
}
