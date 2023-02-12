package com.solid.hibernate.cache.ehcache.http.api.query;

import com.solid.hibernate.cache.ehcache.api.service.query.result.GetCachedRecordQueryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// request mapping not allowed on inherited interface
public interface GetCachedRecordQueryEndpoint {

    @GetMapping("/ehcache")
    @ResponseBody
    GetCachedRecordQueryResult handle();
}
