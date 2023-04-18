package com.accenture.techEventsBack.apiService.controllers;


import com.accenture.techEventsBack.domain.models.EventResponseEvent;
import com.accenture.techEventsBack.domain.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "*")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventResponseEvent>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}
