package com.solid.common.lib.cqs.handlers.query.handler;

import com.solid.common.lib.cqs.datatypes.query.definition.AbstractQuery;
import com.solid.common.lib.cqs.datatypes.query.result.AbstractQueryResult;
import org.springframework.transaction.annotation.Transactional;

public interface QueryHandler<Q extends AbstractQuery, R extends AbstractQueryResult> {
    R postValidate(Q query);

    void validate(Q query);

    @Transactional(readOnly = true)
    default R handle(Q query) {
        validate(query);
        return postValidate(query);
    }
}
