package com.solid.hibernate.cache.ehcache.api.service.query.result;

import com.solid.common.lib.cqs.datatypes.query.result.AbstractQueryResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetCachedRecordQueryResult implements AbstractQueryResult {
    //@Singular - jdk19 problem
    @Builder.Default
    private List<String> messages = new ArrayList<>();
}
