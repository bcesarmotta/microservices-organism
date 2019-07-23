package com.microservices.footballTeam.controller;

import com.microservices.commons.response.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class ExceptionHandlerController {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleValidationonSaveException(final Exception e) {
        return new ResponseEntity<Error>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
