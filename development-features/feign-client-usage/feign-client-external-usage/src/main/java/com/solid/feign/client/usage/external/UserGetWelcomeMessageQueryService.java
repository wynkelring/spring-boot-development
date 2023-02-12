package com.solid.feign.client.usage.external;

import com.solid.common.lib.feign.configuration.UserContextConfig;
import com.solid.feign.client.usage.http.api.query.GetWelcomeMessageQueryEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "UserGetWelcomeMessageQueryService", url = "http://localhost:8080/",
        configuration = {UserContextConfig.class})
public interface UserGetWelcomeMessageQueryService extends GetWelcomeMessageQueryEndpoint {
}
