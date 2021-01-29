package com.reputation.pages.templates.service;

import com.reputation.pages.templates.dao.TemplateUrlToFileNameMappingDao;
import com.reputation.pages.templates.utils.TemplateStatus;
import com.reputation.utils.idgenerator.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagesTemplatesManagerService {

    private static final Logger logger = LoggerFactory.getLogger(PagesTemplatesManagerService.class);

    private TemplateUrlToFileNameMappingDao templateUrlToFileNameMappingDao;

    @Autowired
    public PagesTemplatesManagerService(TemplateUrlToFileNameMappingDao templateUrlToFileNameMappingDao) {
        this.templateUrlToFileNameMappingDao = templateUrlToFileNameMappingDao;
    }
}
