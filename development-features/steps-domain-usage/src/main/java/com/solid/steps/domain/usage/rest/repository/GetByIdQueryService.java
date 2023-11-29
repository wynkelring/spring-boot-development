package com.solid.steps.domain.usage.rest.repository;

import com.solid.common.lib.steps.domain.device.DeviceStepName;
import org.springframework.cloud.openfeign.FeignClient;

import java.security.SecureRandom;
import java.util.UUID;

@FeignClient(name = "GetByIdQueryService", url = "http://localhost:8080/")
public interface GetByIdQueryService {
    default String handle(UUID deviceId, UUID deviceTypeId) {
        return DeviceStepName.values()[new SecureRandom().nextInt(DeviceStepName.values().length)].name();
    }
}
