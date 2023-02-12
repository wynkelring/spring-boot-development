package com.solid.feign.client.usage.impl.controller.query;

import com.solid.feign.client.usage.api.service.query.definition.GetWelcomeMessageQuery;
import com.solid.feign.client.usage.api.service.query.handler.GetWelcomeMessageQueryHandler;
import com.solid.feign.client.usage.api.service.query.result.GetWelcomeMessageQueryResult;
import com.solid.feign.client.usage.http.api.query.GetWelcomeMessageQueryEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetWelcomeMessageQueryController implements GetWelcomeMessageQueryEndpoint {

    private final GetWelcomeMessageQueryHandler handler;

    @Override
    public GetWelcomeMessageQueryResult handle(String sth, String qp) {
        return handler.handle(new GetWelcomeMessageQuery(qp));
    }
}