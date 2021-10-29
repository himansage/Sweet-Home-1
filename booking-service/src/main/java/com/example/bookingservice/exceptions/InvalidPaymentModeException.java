package com.example.bookingservice.exceptions;

import com.example.bookingservice.constants.ErrorMessages;
import com.example.bookingservice.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;

public class InvalidPaymentModeException extends RuntimeException{
    private int statusCode;
    public InvalidPaymentModeException() {
        super(ErrorMessages.INVALID_MODE_OF_PAYMENT);
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
