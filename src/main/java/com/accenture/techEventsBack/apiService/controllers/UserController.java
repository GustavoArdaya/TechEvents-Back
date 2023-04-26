package com.accenture.techEventsBack.apiService.controllers;

import com.accenture.techEventsBack.domain.dtos.UserResponseUser;
import com.accenture.techEventsBack.domain.services.EventService;
import com.accenture.techEventsBack.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserResponseUser>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
