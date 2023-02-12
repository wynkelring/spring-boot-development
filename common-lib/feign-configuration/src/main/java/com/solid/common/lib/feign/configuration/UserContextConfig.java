package com.solid.common.lib.feign.configuration;

import feign.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;


public class UserContextConfig {
    @Bean
    public RequestInterceptor userContextRequestInterceptor() {
        return template -> {
            Logger LOGGER = LoggerFactory.getLogger(ClientContextConfig.class);
            LOGGER.info("UserContextConfig");
            template.header("Bearer", "UserContextConfig");
        };
    }
}
