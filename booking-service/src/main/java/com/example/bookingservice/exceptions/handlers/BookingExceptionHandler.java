package com.example.bookingservice.exceptions.handlers;

import com.example.bookingservice.exceptions.InvalidBookingIdException;
import com.example.bookingservice.exceptions.InvalidPaymentModeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleInvalidPaymentModeException(InvalidPaymentModeException e) {
        return new ResponseEntity(e.getErrorResponse(), HttpStatus.valueOf(e.getStatusCode()));
    }

    @ExceptionHandler
    public ResponseEntity handleInvalidBookingIdException(InvalidBookingIdException e) {
        return new ResponseEntity(e.getErrorResponse(), HttpStatus.valueOf(e.getStatusCode()));
    }
}
