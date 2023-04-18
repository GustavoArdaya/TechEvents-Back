package com.accenture.techEventsBack.infrastructure.repositories;

import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = """
            select u
            from User u
            join u.signedInEvents se
            where se.id = :eventId
            """)
    Set<User> findAllParticipants(@Param("eventId") Long eventId);
}
