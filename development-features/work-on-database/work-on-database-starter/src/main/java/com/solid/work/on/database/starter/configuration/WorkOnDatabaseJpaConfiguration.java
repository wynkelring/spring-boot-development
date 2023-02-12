package com.solid.work.on.database.starter.configuration;

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
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "workOnDatabaseEntityManagerFactory",
        transactionManagerRef = "workOnDatabaseTransactionManager",
        basePackages = {"com.solid.work.on.database"})
@EntityScan("com.solid.work.on.database")
public class WorkOnDatabaseJpaConfiguration {

    @Value("spring.jpa.database-platform")
    private String databasePlatform;
    @Value("spring.jpa.hibernate.ddl-auto")
    private String ddlAuto;

    @Primary
    @Bean(name = "workOnDatabaseDataSourceProperties")
    @ConfigurationProperties("spring.datasource.work-on-database")
    public DataSourceProperties workOnDatabaseDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "workOnDatabaseDataSource")
    @ConfigurationProperties("spring.datasource.work-on-database.configuration")
    public DataSource workOnDatabaseDataSource(@Qualifier("workOnDatabaseDataSourceProperties") DataSourceProperties workOnDatabaseDataSourceProperties) {
        return workOnDatabaseDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @DependsOn("workOnDatabaseFlyway")
    @Bean(name = "workOnDatabaseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean workOnDatabaseEntityManagerFactory(
            EntityManagerFactoryBuilder workOnDatabaseEntityManagerFactoryBuilder,
            @Qualifier("workOnDatabaseDataSource") DataSource workOnDatabaseDataSource) {

        Map<String, String> workOnDatabaseJpaProperties = new HashMap<>();
        workOnDatabaseJpaProperties.put("spring.jpa.database-platform", databasePlatform);
        workOnDatabaseJpaProperties.put("spring.jpa.hibernate.ddl-auto", ddlAuto);

        return workOnDatabaseEntityManagerFactoryBuilder
                .dataSource(workOnDatabaseDataSource)
                .packages("com.solid.work.on.database")
                .persistenceUnit("workOnDatabaseDataSource")
                .properties(workOnDatabaseJpaProperties)
                .build();
    }

    @Primary
    @Bean(name = "workOnDatabaseTransactionManager")
    public PlatformTransactionManager workOnDatabaseTransactionManager(
            @Qualifier("workOnDatabaseEntityManagerFactory") EntityManagerFactory workOnDatabaseEntityManagerFactory) {

        return new JpaTransactionManager(workOnDatabaseEntityManagerFactory);
    }
}
