package com.reputation.pages.templates.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLsFilterCriteriaMap {

    private Map<String, List<String>> map;

    public URLsFilterCriteriaMap() {
        map = new HashMap();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public List<String> getFilterValues(String key) {
        return map.get(key);
    }

    public List<String> addFilter(String key, List<String> value) {
        return map.put(key, value);
    }

    public Set getAllFilterKeys() {
        return map.keySet();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
