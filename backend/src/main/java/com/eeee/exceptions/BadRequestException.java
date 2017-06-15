package com.eeee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Charles on 15/06/2017.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad Request")  // 400
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
