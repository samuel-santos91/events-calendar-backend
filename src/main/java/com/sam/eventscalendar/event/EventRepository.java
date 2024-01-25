package com.sam.eventscalendar.event;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
  List<Event> findByDate(LocalDate date);

  List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
