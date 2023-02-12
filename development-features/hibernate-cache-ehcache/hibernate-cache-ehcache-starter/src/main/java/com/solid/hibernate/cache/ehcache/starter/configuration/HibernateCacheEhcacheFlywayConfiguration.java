package com.solid.hibernate.cache.ehcache.starter.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HibernateCacheEhcacheFlywayConfiguration {

    private final DataSource hibernateEhcacheDataSource;

    public HibernateCacheEhcacheFlywayConfiguration(@Qualifier("hibernateEhcacheDataSource") DataSource hibernateEhcacheDataSource) {
        this.hibernateEhcacheDataSource = hibernateEhcacheDataSource;
    }

    @Bean("hibernateEhcacheFlyway")
    public void hibernateEhcacheFlyway() {
        Flyway.configure()
                .dataSource(hibernateEhcacheDataSource)
                .locations("hibernate-ehcache/migrations")
                .baselineOnMigrate(true)
                .load()
                .migrate();
    }

}