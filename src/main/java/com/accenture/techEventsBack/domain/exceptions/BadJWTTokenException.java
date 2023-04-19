package com.accenture.techEventsBack.domain.exceptions;

public class BadJWTTokenException extends RuntimeException{
    public BadJWTTokenException(String message) {
        super(message);
    }
}
