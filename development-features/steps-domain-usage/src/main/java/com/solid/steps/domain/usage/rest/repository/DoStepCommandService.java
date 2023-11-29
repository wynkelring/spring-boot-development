package com.solid.steps.domain.usage.rest.repository;

import com.solid.common.lib.steps.domain.StepEndpointHandler;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "DoStepCommandService", url = "http://localhost:8080/")
public interface DoStepCommandService extends StepEndpointHandler {
    @Override
    default void handle() throws RuntimeException {
        // do nothing
    }
}
