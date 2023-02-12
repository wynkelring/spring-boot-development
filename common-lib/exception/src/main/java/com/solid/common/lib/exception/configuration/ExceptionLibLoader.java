package com.solid.common.lib.exception.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.solid.common.lib.exception")
public class ExceptionLibLoader {
}
