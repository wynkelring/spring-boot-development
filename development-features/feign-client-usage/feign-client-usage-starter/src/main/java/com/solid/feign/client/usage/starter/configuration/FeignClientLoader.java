package com.solid.feign.client.usage.starter.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.solid"})
public class FeignClientLoader {

}
