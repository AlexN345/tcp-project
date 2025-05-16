package com.example.myapp.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
