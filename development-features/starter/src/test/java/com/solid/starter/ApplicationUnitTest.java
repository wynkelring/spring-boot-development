package com.solid.starter;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootTest
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public interface ApplicationUnitTest {
}
