package com.accenture.techEventsBack.domain.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class EventRequestEvent {

    private String title;
    private String description;
    //TODO image
    private LocalDate _date;
    private LocalTime _time;
    private Integer max_participants;
    private Boolean isHighlighted;
}
