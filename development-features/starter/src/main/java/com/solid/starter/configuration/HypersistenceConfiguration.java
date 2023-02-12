package com.solid.starter.configuration;

import io.hypersistence.optimizer.HypersistenceOptimizer;
import io.hypersistence.optimizer.core.config.JpaConfig;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Profile("jpa-test")
@ConditionalOnClass(name = "io.hypersistence.optimizer.HypersistenceOptimizer")
@Configuration
public class HypersistenceConfiguration {

    @Bean
    public HypersistenceOptimizer hypersistenceOptimizer(EntityManagerFactory entityManagerFactory) {
        log.info("Some events description in on https://vladmihalcea.com/hypersistence-optimizer/docs/user-guide/");
        return new HypersistenceOptimizer(new JpaConfig(entityManagerFactory));
    }
}