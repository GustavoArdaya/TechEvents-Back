package com.accenture.techEventsBack.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserResponseUser {
    private String loginName;
    private String email;
    //TODO image
    private Set<UserResponseEvent> signedInEvents;
}
