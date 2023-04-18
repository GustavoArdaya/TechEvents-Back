package com.accenture.techEventsBack.domain.exceptions;

public class UserAlreadySignedInException extends RuntimeException {
    public UserAlreadySignedInException(String message) {
        super(message);
    }
}
