package com.solid.common.lib.exception;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter(AccessLevel.PROTECTED)
public class TokenizedException extends RuntimeException {

    private static final String UNHANDLED_TOKEN = "application_error_unhandled_token";
    private String token;
    private String description;
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private Serializable object;

    public TokenizedException() {
        super(UNHANDLED_TOKEN);
        this.token = UNHANDLED_TOKEN;
    }

    public TokenizedException(RuntimeException ex) {
        super(UNHANDLED_TOKEN, ex);
        this.token = UNHANDLED_TOKEN;
        this.description = ex.getMessage();
    }

    public TokenizedException(Exception ex) {
        super(UNHANDLED_TOKEN, ex);
        this.token = UNHANDLED_TOKEN;
        this.description = ex.getMessage();
    }

    public TokenizedException(TokenizedException ex) {
        super(ex.getToken(), ex);
        this.token = ex.getToken();
        this.description = ex.getMessage();
        this.httpStatus = ex.getHttpStatus();
        this.object = ex.getObject();
    }

    public TokenizedException(String token, String description, HttpStatus httpStatus) {
        super(token);
        this.token = token;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public TokenizedException(String token, HttpStatus httpStatus) {
        super(token);
        this.token = token;
        this.httpStatus = httpStatus;
    }

    public static TokenizedException getException(String token, HttpStatus httpStatus) {
        return new TokenizedException(token, httpStatus);
    }

    public TokenizedException object(Serializable object) {
        setObject(object);
        return this;
    }
}
