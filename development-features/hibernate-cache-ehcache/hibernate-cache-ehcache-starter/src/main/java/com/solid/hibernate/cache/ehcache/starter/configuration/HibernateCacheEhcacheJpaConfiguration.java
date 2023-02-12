package com.solid.hibernate.cache.ehcache.starter.configuration;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "hibernateEhcacheEntityManagerFactory",
        transactionManagerRef = "hibernateEhcacheTransactionManager",
        basePackages = {"com.solid.hibernate.cache.ehcache"})
@EntityScan("com.solid.hibernate.cache.ehcache")
public class HibernateCacheEhcacheJpaConfiguration {

    @Value("spring.jpa.database-platform")
    private String databasePlatform;
    @Value("spring.jpa.hibernate.ddl-auto")
    private String ddlAuto;

    @Bean(name = "hibernateEhcacheDataSourceProperties")
    @ConfigurationProperties("spring.datasource.hibernate-ehcache")
    public DataSourceProperties hibernateEhcacheDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "hibernateEhcacheDataSource")
    @ConfigurationProperties("spring.datasource.hibernate-ehcache.configuration")
    public DataSource hibernateEhcacheDataSource(
            @Qualifier("hibernateEhcacheDataSourceProperties") DataSourceProperties hibernateEhcacheDataSourceProperties) {
        return hibernateEhcacheDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @DependsOn("hibernateEhcacheFlyway")
    @Bean(name = "hibernateEhcacheEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean hibernateEhcacheEntityManagerFactory(
            EntityManagerFactoryBuilder hibernateEhcacheEntityManagerFactoryBuilder,
            @Qualifier("hibernateEhcacheDataSource") DataSource hibernateEhcacheDataSource) {

        Map<String, String> hibernateEhcacheJpaProperties = new HashMap<>();
        hibernateEhcacheJpaProperties.put("spring.jpa.database-platform", databasePlatform);
        hibernateEhcacheJpaProperties.put("spring.jpa.hibernate.ddl-auto", ddlAuto);

        return hibernateEhcacheEntityManagerFactoryBuilder
                .dataSource(hibernateEhcacheDataSource)
                .packages("com.solid.hibernate.cache.ehcache")
                .persistenceUnit("hibernateEhcacheDataSource")
                .properties(hibernateEhcacheJpaProperties)
                .build();
    }

    @Bean(name = "hibernateEhcacheTransactionManager")
    public PlatformTransactionManager hibernateEhcacheTransactionManager(
            @Qualifier("hibernateEhcacheEntityManagerFactory") EntityManagerFactory hibernateEhcacheEntityManagerFactory) {

        return new JpaTransactionManager(hibernateEhcacheEntityManagerFactory);
    }
}
