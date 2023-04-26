package com.accenture.techEventsBack.domain.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserResponseUser {
    private Long id;
    private String loginName;
    private String email;
    //TODO image
    private List<UserResponseEvent> signedInEvents;
}
