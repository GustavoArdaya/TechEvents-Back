package com.accenture.techEventsBack.domain.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class UserResponseEvent {
    private Long id;
    private String title;
    private String description;
    private LocalDate _date;
    private LocalTime _time;
    private Integer max_participants;
    private Boolean isHighlighted;
}
