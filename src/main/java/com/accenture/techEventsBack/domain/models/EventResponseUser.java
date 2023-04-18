package com.accenture.techEventsBack.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventResponseUser {
    private String username;
    private String email;
    //TODO image
}
