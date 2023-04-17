package com.accenture.techEventsBack.infrastructure.repositories;

import com.accenture.techEventsBack.domain.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long> {
}
