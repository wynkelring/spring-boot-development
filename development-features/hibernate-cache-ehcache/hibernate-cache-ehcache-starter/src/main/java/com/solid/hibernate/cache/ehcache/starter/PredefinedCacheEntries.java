package com.solid.hibernate.cache.ehcache.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "predefined")
public class PredefinedCacheEntries {

    private List<PredefinedEhcacheEntry> entries;

    @Data
    static class PredefinedEhcacheEntry {
        private String name;
        private String description;
    }
}