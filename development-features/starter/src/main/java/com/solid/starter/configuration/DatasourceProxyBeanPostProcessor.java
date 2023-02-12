package com.solid.starter.configuration;

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Profile("jpa-test")
@ConditionalOnProperty(value = "datasource.proxy.enabled",
        havingValue = "true"
)
@ConditionalOnClass(name = "net.ttddyy.dsproxy.support.ProxyDataSource")
@Component
public class DatasourceProxyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof DataSource dataSourceBean) {
            return ProxyDataSourceBuilder.create(dataSourceBean)
                    .name("BatchLogger")
                    .asJson().countQuery()
                    .logQueryBySlf4j(SLF4JLogLevel.INFO).build();
        }
        return bean;
    }

}