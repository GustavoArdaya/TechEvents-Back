package com.accenture.techEventsBack.domain.services;

import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.models.EventResponseEvent;
import com.accenture.techEventsBack.domain.models.EventResponseUser;
import com.accenture.techEventsBack.domain.models.User;
import com.accenture.techEventsBack.infrastructure.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponseEvent> getAllEvents() {
        List<Event> eventsList=eventRepository.findAll();

        List<EventResponseEvent> dtoResponse=new ArrayList<>();
        for (Event event : eventsList) {

            Set<User> participants=eventRepository.findAllParticipants(event.getId());

            Set<EventResponseUser> dtoUserSet=new HashSet<>();
            for(User user:participants){
                EventResponseUser dtoUser=EventResponseUser.builder()
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .build();
                dtoUserSet.add(dtoUser);
            }
            EventResponseEvent dtoEvent=EventResponseEvent.builder()
                    .title(event.getTitle())
                    .description(event.getDescription())
                    ._date(event.get_date())
                    ._time(event.get_time())
                    .max_participants(event.getMax_participants())
                    .isHighlighted(event.getIsHighlighted())
                    .participants(dtoUserSet)
                    .build();
            dtoResponse.add(dtoEvent);
        }

        return dtoResponse;
    }

    public EventResponseEvent getEventById(Long id) {
        Optional<Event> optionalEvent=eventRepository.findById(id);
        if (optionalEvent.isEmpty())throw new RuntimeException("Event not found");
        Event e= optionalEvent.get();

        Set<User> participants=eventRepository.findAllParticipants(e.getId());
        Set<EventResponseUser> dtoUserSet=new HashSet<>();
        for(User user:participants){
            EventResponseUser dtoUser=EventResponseUser.builder()
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .build();
            dtoUserSet.add(dtoUser);
        }
        return EventResponseEvent.builder()
                .title(e.getTitle())
                .description(e.getDescription())
                ._date(e.get_date())
                ._time(e.get_time())
                .isHighlighted(e.getIsHighlighted())
                .max_participants(e.getMax_participants())
                .participants(dtoUserSet)
                .build();
    }
}
