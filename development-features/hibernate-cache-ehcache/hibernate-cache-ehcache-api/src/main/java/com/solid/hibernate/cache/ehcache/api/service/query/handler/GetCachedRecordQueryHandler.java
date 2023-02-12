package com.solid.hibernate.cache.ehcache.api.service.query.handler;

import com.solid.common.lib.cqs.handlers.query.handler.QueryHandler;
import com.solid.hibernate.cache.ehcache.api.service.query.definition.GetCachedRecordQuery;
import com.solid.hibernate.cache.ehcache.api.service.query.result.GetCachedRecordQueryResult;

public interface GetCachedRecordQueryHandler extends QueryHandler<GetCachedRecordQuery, GetCachedRecordQueryResult> {
}
