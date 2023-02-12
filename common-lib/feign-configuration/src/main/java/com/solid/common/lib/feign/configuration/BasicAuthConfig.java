package com.solid.common.lib.feign.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class BasicAuthConfig {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        Logger LOGGER = LoggerFactory.getLogger(BasicAuthConfig.class);
        LOGGER.info("BasicAuthConfig");
        return new BasicAuthRequestInterceptor("username", "password");
    }
}
