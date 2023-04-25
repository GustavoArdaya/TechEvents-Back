package com.accenture.techEventsBack.domain.exceptions;

public class EventAlreadyFullException extends RuntimeException {
    public EventAlreadyFullException(String message) {
        super(message);
    }
}
