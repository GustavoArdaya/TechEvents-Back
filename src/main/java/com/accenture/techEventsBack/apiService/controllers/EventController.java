package com.accenture.techEventsBack.apiService.controllers;



import com.accenture.techEventsBack.domain.dtos.EventRequestEvent;
import com.accenture.techEventsBack.domain.dtos.EventResponseEvent;
import com.accenture.techEventsBack.domain.dtos.EventResponseUser;
import com.accenture.techEventsBack.domain.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public ResponseEntity<List<EventResponseEvent>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public ResponseEntity<EventResponseEvent> getEventById(@PathVariable Long id){
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/{id}/users")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public ResponseEntity<List<EventResponseUser>> getUsersSignedInEventById(@PathVariable Long id){
        return ResponseEntity.ok(eventService.getUsersSignedInEventById(id));
    }

    @PutMapping("/signup/{id}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public ResponseEntity<EventResponseEvent> signUserUpForEvent(@PathVariable Long id){
        return ResponseEntity.ok(eventService.signUserUpForEvent(id));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EventResponseEvent>deleteEventById(@PathVariable Long id){
        return ResponseEntity.ok(eventService.deleteEventById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EventResponseEvent> createNewEvent(@RequestBody EventRequestEvent newEvent) {
        return ResponseEntity.ok(eventService.createNewEvent(newEvent));
    }

}
