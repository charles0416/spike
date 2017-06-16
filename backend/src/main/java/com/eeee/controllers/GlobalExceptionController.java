package com.eeee.controllers;

import com.eeee.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Charles on 16/06/2017.
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    RestError handleBadRequest(HttpServletRequest req, BadRequestException ex) {
        return new RestError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    RestError handleUnknowError(HttpServletRequest req, Exception ex) {
        return new RestError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), req.getRequestURI());
    }
}
