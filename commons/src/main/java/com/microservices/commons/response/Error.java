package com.microservices.commons.response;

public class Error {
    private String error;

    public Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
