package com.solid.feign.client.usage.api.service.query.definition;

import com.solid.common.lib.cqs.datatypes.query.definition.AbstractQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetWelcomeMessageQuery implements AbstractQuery {
    private String qp;
}
