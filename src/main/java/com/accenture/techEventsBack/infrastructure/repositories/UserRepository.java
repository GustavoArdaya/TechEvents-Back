package com.accenture.techEventsBack.infrastructure.repositories;

import com.accenture.techEventsBack.domain.models.Event;
import com.accenture.techEventsBack.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
  Boolean existsByEmail(String email);
  @Query(value = """
            select e
            from Event e
            join e.participants se
            where se.id = :userId
            """)
  List<Event> findAllSignedInEvents(@Param("userId") Long userId);
}
