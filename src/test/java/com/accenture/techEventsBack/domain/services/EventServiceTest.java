package com.accenture.techEventsBack.domain.services;

import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.infrastructure.repositories.EventRepository;
import com.accenture.techEventsBack.infrastructure.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class EventServiceTest {

    private EventService eventService;
    @Mock
    UserRepository userRepository;
    @Mock
    EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
        this.eventService=new EventService(eventRepository,userRepository );
    }

    @Test
    void getAllEvents_returnsEventResponseList() {
        List<Event> eventsList=new ArrayList<>();
        eventsList.add(new Event());

        when(eventRepository.findAll()).thenReturn(eventsList);
        var sut=eventService.getAllEvents();

        assertEquals(eventsList.size(),sut.size());
        verify(eventRepository,times(1)).findAll();
    }
}