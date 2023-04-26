package com.accenture.techEventsBack.domain.services;

import com.accenture.techEventsBack.domain.dtos.EventResponseEvent;
import com.accenture.techEventsBack.domain.dtos.EventResponseUser;
import com.accenture.techEventsBack.domain.dtos.UserResponseEvent;
import com.accenture.techEventsBack.domain.dtos.UserResponseUser;
import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.models.User;
import com.accenture.techEventsBack.infrastructure.repositories.EventRepository;
import com.accenture.techEventsBack.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class UserService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public UserService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public User getUserById(long l) {
        return userRepository.findById(l).get();
    }


    public List<UserResponseUser> getAllUsers() {
        List<User> userList=userRepository.findAll();

        List<UserResponseUser> dtoResponse=new ArrayList<>();
        for (User user : userList) {

            dtoResponse.add(constructDTOUserResponseFromUser(user));
        }
        return dtoResponse;
    }

    private UserResponseUser constructDTOUserResponseFromUser(User user) {
        List<UserResponseEvent> dtoEventsSet=constructListOfDTOEventsOfAUser(user);

        return UserResponseUser.builder()
                .id(user.getId())
                .loginName(user.getLoginName())
                .email(user.getEmail())
                .signedInEvents(dtoEventsSet)
                .build();
    }

    private List<UserResponseEvent> constructListOfDTOEventsOfAUser(User user) {
        List<Event> signedIn=userRepository.findAllSignedInEvents(user.getId());
        List<UserResponseEvent> dtoEventList=new ArrayList<>();
        for(Event event:signedIn){
            UserResponseEvent dtoEvent=UserResponseEvent.builder()
                    .id(event.getId())
                    .title(event.getTitle())
                    .description(event.getDescription())
                    ._date(event.get_date())
                    ._time(event.get_time())
                    .max_participants(event.getMax_participants())
                    .isHighlighted(event.getIsHighlighted())
                    .build();
            dtoEventList.add(dtoEvent);
        }

        return dtoEventList;
    }
}
