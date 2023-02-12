package com.solid.work.on.database.starter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:work-on-database.properties")
public class WorkOnDatabasePropertiesLoader {
}
