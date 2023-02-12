package com.solid.common.lib.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solid.common.lib.exception.datatypes.ResponseResult;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class AbstractControllerExceptionHandler {

    private final ObjectMapper objectMapper;

    private static final String EXCEPTION_LOG_MESSAGE_FORMAT = "Tokenized error {}: {}";

    @ExceptionHandler(TokenizedException.class)
    public ResponseEntity<ResponseResult> handleModuleException(TokenizedException ex) {
        log.error(EXCEPTION_LOG_MESSAGE_FORMAT, ex.getToken(), ex.getDescription());
        log.debug(EXCEPTION_LOG_MESSAGE_FORMAT, ex.getToken(), ex.getDescription(), ex);

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ResponseResult.of(ex));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ResponseResult> handleFeignException(FeignException ex) {

        ResponseResult responseResult = null;
        try {
            if (ex.responseBody().isPresent()) {
                String body = ex.responseBody().map(response -> new String(response.array())).orElse(null);
                if (StringUtils.hasText(body)) {
                    responseResult = objectMapper.readValue(body, ResponseResult.class);
                }
            }
        } catch (IOException e) {
            responseResult = ResponseResult.of(new TokenizedException(e));
        }

        if (responseResult == null || responseResult.getToken() == null) {
            responseResult = ResponseResult.of(new TokenizedException());
        }

        log.error(EXCEPTION_LOG_MESSAGE_FORMAT, responseResult.getToken(), responseResult.getDescription());
        log.debug(EXCEPTION_LOG_MESSAGE_FORMAT, responseResult.getToken(), responseResult.getDescription(), ex);

        return ResponseEntity
                .status(responseResult.getHttpStatus())
                .body(responseResult);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseResult> handleUnexpectedException(Exception ex) {
        TokenizedException tokenizedException = new TokenizedException(ex);

        log.error(EXCEPTION_LOG_MESSAGE_FORMAT, tokenizedException.getToken(), tokenizedException.getDescription());
        log.debug(EXCEPTION_LOG_MESSAGE_FORMAT, tokenizedException.getToken(), tokenizedException.getDescription(), ex);

        return ResponseEntity
                .of(Optional.of(ResponseResult.of(tokenizedException)));
    }
}
