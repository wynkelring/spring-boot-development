package com.solid.common.lib.exception.datatypes;

import com.solid.common.lib.exception.TokenizedException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private String token;
    private String description;
    private HttpStatus httpStatus;
    private Serializable object;

    public static ResponseResult of(TokenizedException ex) {
        return ResponseResult.builder()
                .token(ex.getToken())
                .description(ex.getDescription())
                .httpStatus(ex.getHttpStatus())
                .object(ex.getObject())
                .build();
    }
}
