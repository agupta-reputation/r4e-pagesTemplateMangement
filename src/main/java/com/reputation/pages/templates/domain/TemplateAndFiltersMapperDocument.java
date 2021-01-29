package com.reputation.pages.templates.domain;

import com.reputation.core.Idable;
import com.reputation.dao.annotations.Tenantable;
import com.reputation.pages.templates.utils.URLsFilterCriteriaMap;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(
        value = "template_and_filters_mapper_collection")
@CompoundIndex(
        name = "template_to_filter_idx",
        def = "{tenantId: 1, templateId: 1}",
        unique = true)
public class TemplateAndFiltersMapperDocument implements Idable<String> {
    public static final String FIELD_ID = "id";
    public static final String FIELD_FILTERS_LIST = "urlsFilterCriteriaMap";
    public static final String FIELD_TEMPLATE_ID = "templateId";
    public static final String FIELD_TENANT_ID = "tenantId";

    @Id
    @Field(FIELD_ID)
    private String id;

    @Field(FIELD_TEMPLATE_ID)
    private String templateId;

    @Field(FIELD_FILTERS_LIST)
    private URLsFilterCriteriaMap urlsFilterCriteriaMap;

    @Field(FIELD_TENANT_ID)
    @Tenantable
    private String tenantId;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public URLsFilterCriteriaMap getUrlsFilterCriteriaMap() {
        return urlsFilterCriteriaMap;
    }

    public void setUrlsFilterCriteriaMap(URLsFilterCriteriaMap urlsFilterCriteriaMap) {
        this.urlsFilterCriteriaMap = urlsFilterCriteriaMap;
    }

}
