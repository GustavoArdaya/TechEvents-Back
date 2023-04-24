package com.accenture.techEventsBack.domain.services;

import com.accenture.techEventsBack.domain.exceptions.NotFoundException;
import com.accenture.techEventsBack.domain.exceptions.UserAlreadySignedInException;
import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.dtos.EventResponseEvent;
import com.accenture.techEventsBack.domain.dtos.EventResponseUser;
import com.accenture.techEventsBack.domain.models.User;
import com.accenture.techEventsBack.infrastructure.repositories.EventRepository;
import com.accenture.techEventsBack.infrastructure.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public User getAuthUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUserEmail=authentication.getName();
        return userRepository.findByEmail(loggedUserEmail).get();
    }

    public List<EventResponseUser> constructSetOfDTOUsersOfAnEvent(Event event) {
        List<User> participants=eventRepository.findAllParticipants(event.getId());
        List<EventResponseUser> dtoUserSet=new ArrayList<>();
        for(User user:participants){
            EventResponseUser dtoUser=EventResponseUser.builder()
                    .loginName(user.getLoginName())
                    .email(user.getEmail())
                    .build();
            dtoUserSet.add(dtoUser);
        }
        return dtoUserSet;
    }

    public EventResponseEvent constructDTOEventResponseFromEvent(Event event) {

        List<EventResponseUser> dtoUserSet=constructSetOfDTOUsersOfAnEvent(event);

        return EventResponseEvent.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                ._date(event.get_date())
                ._time(event.get_time())
                .max_participants(event.getMax_participants())
                .isHighlighted(event.getIsHighlighted())
                .participants(dtoUserSet)
                .build();
    }

    public List<EventResponseEvent> getAllEvents() {

        List<Event> eventsList=eventRepository.findAll();

        List<EventResponseEvent> dtoResponse=new ArrayList<>();
        for (Event event : eventsList) {

            dtoResponse.add(constructDTOEventResponseFromEvent(event));
        }

        dtoResponse.sort(Comparator.comparing(EventResponseEvent::get_date).reversed());
        return dtoResponse;
    }

    public EventResponseEvent getEventById(Long id) {
        Optional<Event> optionalEvent=eventRepository.findById(id);
        if (optionalEvent.isEmpty())throw new NotFoundException("Event not found");
        Event e= optionalEvent.get();

        return constructDTOEventResponseFromEvent(e);
    }

    public List<EventResponseUser> getUsersSignedInEventById(Long id) {
        EventResponseEvent event= getEventById(id);
        return event.getParticipants();
    }

    public EventResponseEvent signUserUpForEvent(Long id) {

        User loggedUser=getAuthUser();

        Optional<Event> optionalEvent=eventRepository.findById(id);
        if(optionalEvent.isEmpty()) throw new NotFoundException("Event not found");

        Event event= optionalEvent.get();
        if(loggedUser.getSignedInEvents().contains(event))throw new UserAlreadySignedInException("User is already signed in");

        loggedUser.getSignedInEvents().add(event);
        userRepository.save(loggedUser);

        return constructDTOEventResponseFromEvent(event);
    }
}
