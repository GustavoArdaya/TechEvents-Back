package com.accenture.techEventsBack.infrastructure.repositories;

import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = """
      select u.username, u.email from _users u \s
      join user_events ue\s
      on ue.user_id = u.id\s
      where ue.event_id = eventId\s
      """,nativeQuery = true)
    List<Event> findAllParticipants(Long eventId);
}
