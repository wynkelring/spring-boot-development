package com.solid.starter;

import com.solid.common.lib.exception.configuration.ExceptionLibLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(proxyBeanMethods = false)
@ComponentScan(basePackages = {"com.solid"})
@Import({ExceptionLibLoader.class})
public class DevelopmentFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopmentFeaturesApplication.class, args);
    }

}
