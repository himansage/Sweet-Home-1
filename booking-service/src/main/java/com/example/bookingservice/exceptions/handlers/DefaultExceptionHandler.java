package com.example.bookingservice.exceptions.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleJsonProcessingException(Exception e) {
        return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
