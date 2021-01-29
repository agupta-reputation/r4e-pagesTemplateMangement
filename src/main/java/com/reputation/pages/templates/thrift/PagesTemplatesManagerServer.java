package com.reputation.pages.templates.thrift;

import com.reputation.common.service.MiddlewareThriftService;
import com.reputation.pages.templates.dao.TemplateUrlToFileNameMappingDao;
import com.reputation.pages.templates.service.PagesTemplatesManagerService;
import com.reputation.thrift.pages.templates.R4EPagesTemplateManagement;
import com.reputation.thrift.pages.templates.TemplateUrlToFileNameMapping;
import com.reputation.thrift.r4e.common.RequestHeader;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagesTemplatesManagerServer extends MiddlewareThriftService implements R4EPagesTemplateManagement.Iface {

    private static final Logger logger = LoggerFactory.getLogger(PagesTemplatesManagerServer.class);

    @Autowired
    private PagesTemplatesManagerService pagesTemplatesManagerService;

    @Override
    public TemplateUrlToFileNameMapping addTemplateFile(RequestHeader requestHeader, String pageUrl,
            int templateVersion, String filePath) {
        return invoke(
                defaultMiddleware(
                        "addTemplateFile",
                        new TemplateUrlToFileNameMapping(),
                        (request, response) -> {
                            return pagesTemplatesManagerService.addTemplateFile(pageUrl, templateVersion, filePath)
                                    .toThrift();
                        }),
                requestHeader);
    }

    @Override
    public String getPublishedTemplateFileName(RequestHeader requestHeader, String pageUrl, int templateVersion) {
        return invoke(
                defaultMiddleware(
                        "getPublishedTemplateFileName",
                        new String(""),
                        (request, response) -> {
                            return pagesTemplatesManagerService.getPublishedTemplateFileName(pageUrl, templateVersion);
                        }),
                requestHeader);
    }

    @Override
    public List<String> getAllTemplatesFileName(RequestHeader requestHeader, String pageUrl, int templateVersion) {
        return invoke(
                defaultMiddleware(
                        "getAllTemplatesFileName",
                        new ArrayList<String>(),
                        (request, response) -> {
                            List<com.reputation.pages.templates.domain.TemplateUrlToFileNameMapping> allTemplatesFileName = pagesTemplatesManagerService
                                    .getAllTemplatesFileName(pageUrl);
                            ArrayList<String> fileNames = new ArrayList<>();
                            for (com.reputation.pages.templates.domain.TemplateUrlToFileNameMapping templateUrlToFileNameMapping : allTemplatesFileName) {
                                fileNames.add(templateUrlToFileNameMapping.getFilePath());
                            }
                            return fileNames;
                        }),
                requestHeader);
    }

    @Override
    public String getPublishedTemplateFile(RequestHeader requestHeader, String pageUrl, int templateVersion)
            throws TException {
        return null;
    }

    @Override
    public boolean setTemplateStatusToPublished(RequestHeader requestHeader, String pageUrl, int templateVersion)
            throws TException {
        return false;
    }

    @Override
    public boolean deletePublishedTemplate(RequestHeader requestHeader, String pageUrl, int templateVersion)
            throws TException {
        return false;
    }

    @Override
    public boolean deleteAllTemplate(RequestHeader requestHeader, String pageUrl, int templateVersion)
            throws TException {
        return false;
    }
}
