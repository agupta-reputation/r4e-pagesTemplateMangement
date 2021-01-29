package com.reputation.pages.templates.utils;

public enum TemplateStatus {

    PUBLISHED(1, "published"),
    UNPUBLISHED(2, "un-published");

    private int pos;
    private final String value;

    TemplateStatus(String value) {
        this.value = value;
    }

    TemplateStatus(int pos, String value) {
        this.pos = pos;
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
