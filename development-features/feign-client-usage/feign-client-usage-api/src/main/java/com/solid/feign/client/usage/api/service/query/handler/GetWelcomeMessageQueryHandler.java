package com.solid.feign.client.usage.api.service.query.handler;


import com.solid.common.lib.cqs.handlers.query.handler.QueryHandler;
import com.solid.feign.client.usage.api.service.query.definition.GetWelcomeMessageQuery;
import com.solid.feign.client.usage.api.service.query.result.GetWelcomeMessageQueryResult;

public interface GetWelcomeMessageQueryHandler extends QueryHandler<GetWelcomeMessageQuery, GetWelcomeMessageQueryResult> {
}
