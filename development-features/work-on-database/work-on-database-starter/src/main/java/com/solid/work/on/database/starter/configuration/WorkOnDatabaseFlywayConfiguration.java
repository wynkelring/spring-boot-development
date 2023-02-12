package com.solid.work.on.database.starter.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class WorkOnDatabaseFlywayConfiguration {

    private final DataSource workOnDatabaseDataSource;

    public WorkOnDatabaseFlywayConfiguration(@Qualifier("workOnDatabaseDataSource") DataSource workOnDatabaseDataSource) {
        this.workOnDatabaseDataSource = workOnDatabaseDataSource;
    }

    @Bean("workOnDatabaseFlyway")
    public void workOnDatabaseFlyway() {
        Flyway.configure()
                .dataSource(workOnDatabaseDataSource)
                .locations("work-on-database/migrations")
                .baselineOnMigrate(true)
                .load()
                .migrate();
    }

}