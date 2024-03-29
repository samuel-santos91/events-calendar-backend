package com.sam.eventscalendar.event;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  public List<Event> getEventsByMonthAndYear(int month, int year) {
    LocalDate startDate = LocalDate.of(year, month + 1, 1);
    LocalDate endDate = LocalDate
      .of(year, (month + 1) % 12 + 1, 1)
      .minusDays(1);

    return eventRepository.findByDateBetween(startDate, endDate);
  }

  public List<Event> getEventsByDate(LocalDate date) {
    return eventRepository.findByDate(date);
  }

  public Optional<Event> getById(Long id) {
    Optional<Event> foundEvent = eventRepository.findById(id);
    return foundEvent;
  }

  public Event createEvent(EventCreateDTO data) {
    Event event = new Event(
      data.getTitle(),
      data.getDescription(),
      data.getTime(),
      data.getDate()
    );

    Event created = eventRepository.save(event);
    return created;
  }

  public boolean deleteById(Long id) {
    Optional<Event> foundEvent = this.getById(id);

    if (foundEvent.isPresent()) {
      this.eventRepository.delete(foundEvent.get());
      return true;
    }
    return false;
  }

  public Optional<Event> updateById(Long id, EventCreateDTO data) {
    Optional<Event> foundEvent = this.getById(id);

    if (foundEvent.isPresent()) {
      Event toUpdate = foundEvent.get();

      toUpdate.setTitle(data.getTitle());
      toUpdate.setDescription(data.getDescription());
      toUpdate.setTime(data.getTime());
      toUpdate.setDate(data.getDate());

      Event updatedEvent = eventRepository.save(toUpdate);

      return Optional.of(updatedEvent);
    }

    return foundEvent;
  }
}
