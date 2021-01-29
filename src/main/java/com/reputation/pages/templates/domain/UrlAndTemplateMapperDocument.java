package com.reputation.pages.templates.domain;

import com.reputation.dao.annotations.Tenantable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(
        value = "url_and_template_mapper_collection")
@CompoundIndexes(
        value = {
                @CompoundIndex(
                        name = "pageURL_unique_key_constraint",
                        def = "{pageURL:1}",
                        unique = true),
                @CompoundIndex(
                        name = "pageCode_templateId_templateVersion",
                        def = "{pageURL:1}")
        })
public class UrlAndTemplateMapperDocument {

    private static final String FIELD_ID = "id";
    private static final String FIELD_PAGE_URL = "pageURL";
    private static final String FIELD_PAGE_CODE = "pageCode";
    private static final String FIELD_TEMPLATE_ID = "templateId";
    private static final String FIELD_TEMPLATE_VERSION = "templateVersion";
    private static final String FIELD_STATIC_FILE_NAME = "staticFileName";
    private static final String FIELD_TENANT_ID = "tenantId";

    @Id
    @Field(FIELD_ID)
    private String id;

    @Indexed
    @Field(FIELD_PAGE_URL)
    private String pageURL;

    @Indexed
    @Field(FIELD_PAGE_CODE)
    private String pageCode;

    @Indexed
    @Field(FIELD_TEMPLATE_ID)
    private String templateId;

    @Indexed
    @Field(FIELD_TEMPLATE_VERSION)
    private int templateVersion;

    @Indexed
    @Field(FIELD_STATIC_FILE_NAME)
    private int staticFileName;

    @Indexed
    @Tenantable
    @Field(FIELD_TENANT_ID)
    private String tenantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public int getTemplateVersion() {
        return templateVersion;
    }

    public void setTemplateVersion(int templateVersion) {
        this.templateVersion = templateVersion;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public int getStaticFileName() {
        return staticFileName;
    }

    public void setStaticFileName(int staticFileName) {
        this.staticFileName = staticFileName;
    }
}
