package com.solid.feign.client.usage.external;

import com.solid.common.lib.feign.configuration.ClientContextConfig;
import com.solid.feign.client.usage.http.api.query.GetWelcomeMessageQueryEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ClientGetWelcomeMessageQueryService", url = "http://localhost:8080/",
        configuration = {ClientContextConfig.class})
public interface ClientGetWelcomeMessageQueryService extends GetWelcomeMessageQueryEndpoint {
}
