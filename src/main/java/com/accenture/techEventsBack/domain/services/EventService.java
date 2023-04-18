package com.accenture.techEventsBack.domain.services;

import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.models.EventResponseEvent;
import com.accenture.techEventsBack.domain.models.EventResponseUser;
import com.accenture.techEventsBack.domain.models.User;
import com.accenture.techEventsBack.infrastructure.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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



            Set<EventResponseUser> dtoUserSet=new HashSet<>();
            for(User user:event.getParticipants()){
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
}
