package com.accenture.techEventsBack.security.auth;


import com.accenture.techEventsBack.domain.models.Role;
import com.accenture.techEventsBack.domain.models.User;
import com.accenture.techEventsBack.infrastructure.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitUsers {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    public InitUsers(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void initUsers() {
        var user = User.builder()
                .email("admin@admin.com")
                .firstname("Admin")
                .username("Admin")
                .password(passwordEncoder.encode("password"))
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
        var authReq = AuthenticationRequest.builder()
                .email("admin@admin.com")
                .password("password")
                .build();
        authenticationService.authenticate(authReq);
        var registerRequest = RegisterRequest.builder()
                .email("user@user.com")
                .username("User")
                .firstname("User")
                .password("password")
                .build();
        authenticationService.register(registerRequest);
    }

}
