package com.solid.hibernate.cache.ehcache.api.service.query.definition;

import com.solid.common.lib.cqs.datatypes.query.definition.AbstractQuery;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class GetCachedRecordQuery implements AbstractQuery {
}
