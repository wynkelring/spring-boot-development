package com.solid.feign.client.usage.api.service.query.result;

import com.solid.common.lib.cqs.datatypes.query.result.AbstractQueryResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetWelcomeMessageQueryResult implements AbstractQueryResult {
    private String message;
}
