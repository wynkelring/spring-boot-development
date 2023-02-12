package com.solid.common.lib.feign.configuration;

import feign.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class ClientContextConfig {
    @Bean
    public RequestInterceptor clientContextRequestInterceptor() {
        return template -> {
            Logger LOGGER = LoggerFactory.getLogger(ClientContextConfig.class);
            LOGGER.info("ClientContextConfig");
            //get bearer, use @value
            template.header("Bearer", "ClientContextConfig");
        };
    }
}
