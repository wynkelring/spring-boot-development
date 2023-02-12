package com.solid.feign.client.usage.impl.exception;

import com.solid.common.lib.exception.TokenizedException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class FeignClientUsageException extends TokenizedException {
    public static final TokenizedException QP_PARAMETER_EXCEPTION =
            getException("qp_parameter_exception", HttpStatus.BAD_REQUEST);
}
