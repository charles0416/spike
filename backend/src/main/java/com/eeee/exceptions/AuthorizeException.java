package com.eeee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Charles on 15/06/2017.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid user or password")  // 401
public class AuthorizeException extends RuntimeException {
    public AuthorizeException(String message) {
        super(message);
    }
}
