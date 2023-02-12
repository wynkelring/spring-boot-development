package com.solid.hibernate.cache.ehcache.starter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:hibernate-cache-ehcache.properties")
public class HibernateCacheEhcachePropertiesLoader {
}
