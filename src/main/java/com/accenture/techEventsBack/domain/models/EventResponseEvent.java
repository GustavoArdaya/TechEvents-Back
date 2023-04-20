package com.accenture.techEventsBack.domain.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Builder
public class EventResponseEvent {
    private String title;
    private String description;
    //TODO image
    private LocalDate _date;
    private LocalTime _time;
    private Integer max_participants;
    private Boolean isHighlighted;
    Set<EventResponseUser> participants;
}
