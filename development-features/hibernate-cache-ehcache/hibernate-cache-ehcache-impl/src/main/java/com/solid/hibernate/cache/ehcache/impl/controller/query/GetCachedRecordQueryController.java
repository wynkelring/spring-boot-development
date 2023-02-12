package com.solid.hibernate.cache.ehcache.impl.controller.query;

import com.solid.hibernate.cache.ehcache.api.service.query.definition.GetCachedRecordQuery;
import com.solid.hibernate.cache.ehcache.api.service.query.handler.GetCachedRecordQueryHandler;
import com.solid.hibernate.cache.ehcache.api.service.query.result.GetCachedRecordQueryResult;
import com.solid.hibernate.cache.ehcache.http.api.query.GetCachedRecordQueryEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCachedRecordQueryController implements GetCachedRecordQueryEndpoint {

    private final GetCachedRecordQueryHandler handler;

    @Override
    public GetCachedRecordQueryResult handle() {
        return handler.handle(GetCachedRecordQuery.builder().build());
    }
}
