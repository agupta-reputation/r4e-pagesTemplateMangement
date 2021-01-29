package com.reputation.pages.templates.dao;

import com.reputation.dao.mongo.AbstractDao;
import com.reputation.dao.mongo.MongoTemplates;
import com.reputation.pages.templates.utils.TemplateStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateUrlToFileNameMappingDao extends AbstractDao<TemplateAndFiltersMapperCollection, String> {

    private static final Logger logger = LoggerFactory.getLogger(TemplateUrlToFileNameMappingDao.class);

    @Autowired
    public TemplateUrlToFileNameMappingDao(MongoTemplates mongoTemplates) {
        super(mongoTemplates);
    }

    public List<TemplateAndFiltersMapperCollection> findAllTemplatesByURL(String url) {
        Query query = new Query();
        query.addCriteria(Criteria.where("page_url").is(url));
        return null;
    }

    public TemplateAndFiltersMapperCollection findTemplateByURLAndTemplateVersion(String url, int version) {
        Query query = new Query();
        query.addCriteria(Criteria.where("page_url").is(url));
        query.addCriteria(Criteria.where("template_status").is(TemplateStatus.PUBLISHED));
        query.addCriteria(Criteria.where("template_version").is(version));
        return null;
    }

    public List<TemplateAndFiltersMapperCollection> findPublishedTemplateByURL(String url) {
        Query query = new Query();
        query.addCriteria(Criteria.where("page_url").is(url));
        query.addCriteria(Criteria.where("template_status").is(TemplateStatus.PUBLISHED));
        return null;
    }

    public TemplateAndFiltersMapperCollection findPublishedTemplateByURLAndTemplateVersion(String url, int version) {
        Query query = new Query();
        query.addCriteria(Criteria.where("page_url").is(url));
        query.addCriteria(Criteria.where("template_status").is(TemplateStatus.PUBLISHED));
        query.addCriteria(Criteria.where("template_version").is(version));
        return null;
    }
}
