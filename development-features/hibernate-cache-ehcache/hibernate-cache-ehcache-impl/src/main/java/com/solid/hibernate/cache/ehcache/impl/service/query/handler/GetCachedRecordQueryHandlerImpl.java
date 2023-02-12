package com.solid.hibernate.cache.ehcache.impl.service.query.handler;

import com.solid.hibernate.cache.ehcache.api.service.query.definition.GetCachedRecordQuery;
import com.solid.hibernate.cache.ehcache.api.service.query.handler.GetCachedRecordQueryHandler;
import com.solid.hibernate.cache.ehcache.api.service.query.result.GetCachedRecordQueryResult;
import com.solid.hibernate.cache.ehcache.impl.repository.EhcacheTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCachedRecordQueryHandlerImpl implements GetCachedRecordQueryHandler {

    private final EhcacheTestRepository ehcacheTestRepository;

    @Override
    public GetCachedRecordQueryResult postValidate(GetCachedRecordQuery query) {
        /* JDK19 problem with @Singular
        GetCachedRecordQueryResult.GetCachedRecordQueryResultBuilder<?, ?> resultBuilder =
                GetCachedRecordQueryResult.builder();

        ehcacheTestRepository.findAll().forEach(ehcacheTest -> resultBuilder.message(ehcacheTest.getName()));
        return resultBuilder.build();
        */
        GetCachedRecordQueryResult result = GetCachedRecordQueryResult.builder().build();
        ehcacheTestRepository.findAll().forEach(ehcacheTest -> result.getMessages().add(ehcacheTest.getName()));
        return result;
    }

    @Override
    public void validate(GetCachedRecordQuery query) {
    }
}
