package com.accenture.techEventsBack.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
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

    @ManyToMany(mappedBy = "signedInEvents")
    Set<User>participants=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
