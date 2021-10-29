package com.example.bookingservice.exceptions;

import com.example.bookingservice.constants.ErrorMessages;
import com.example.bookingservice.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;

public class InvalidBookingIdException extends RuntimeException{
    private int statusCode;
    public InvalidBookingIdException() {
        super(ErrorMessages.INVALID_BOOKING_ID);
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ErrorResponseDTO getErrorResponse() {
        return ErrorResponseDTO.builder()
                .statusCode(statusCode)
                .message(this.getMessage())
                .build();
    }
}
