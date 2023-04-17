package com.accenture.techEventsBack.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    //TODO image
    private LocalDate _date;
    private LocalTime _time;
    private Integer max_participants;
    private Boolean isHighlighted;

    @ManyToMany
    @JoinTable(name = "user_events",
            joinColumns = {
                    @JoinColumn(name = "event_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    Set<User>participants;
}
