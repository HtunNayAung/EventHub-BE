package com.csci334.EventHub.repository;

import com.csci334.EventHub.entity.Event;
import com.csci334.EventHub.entity.enums.EventType;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csci334.EventHub.entity.enums.EventStatus;

public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findByEventType(EventType type);

    // Events organized by a specific user
    List<Event> findByOrganizerId(String organizerId);

    // Upcoming events (after now)
    List<Event> findByEventDateAfter(LocalDateTime now);

    // Search by title keyword
    List<Event> findByTitleContainingIgnoreCase(String keyword);

    // Fetch all events with the given status.
    List<Event> findByStatus(EventStatus status);

    @Query("SELECT DISTINCT e.organizer.id FROM Event e")
    List<String> findDistinctOrganizerIds();

    @Query("SELECT e.id FROM Event e")
    List<String> findAllEventIds();
}