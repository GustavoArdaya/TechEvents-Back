package com.accenture.techEventsBack.domain.services;

import com.accenture.techEventsBack.domain.models.User;
import com.accenture.techEventsBack.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long l) {
        return userRepository.findById(l).get();
    }
}
