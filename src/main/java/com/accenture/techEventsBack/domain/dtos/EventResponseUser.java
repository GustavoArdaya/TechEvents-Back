package com.accenture.techEventsBack.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseUser {
    private Long id;
    private String loginName;
    private String email;
    //TODO image
}
