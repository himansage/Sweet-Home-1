package com.example.paymentservice.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class ErrorResponse {
    String message;
    int statusCode;
}
