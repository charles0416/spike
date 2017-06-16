package com.eeee.controllers;

/**
 * Created by Charles on 16/06/2017.
 */
public class RestError {

    private String url;
    private int code;
    private String message;

    public RestError(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }

    public RestError() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RestError{" +
                "url='" + url + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
