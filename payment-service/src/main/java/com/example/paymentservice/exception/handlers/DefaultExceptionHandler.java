package com.example.paymentservice.exception.handlers;

import com.example.paymentservice.constants.ErrorMessages;
import com.example.paymentservice.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends RuntimeException{

    @ExceptionHandler
    public ResponseEntity handleRuntimeException(Exception e) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ErrorMessages.SOMETHING_WENT_WRONG)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return new ResponseEntity(errorResponse, HttpStatus.valueOf(errorResponse.getStatusCode()));
    }
}
