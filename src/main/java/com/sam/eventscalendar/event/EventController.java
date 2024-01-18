package com.sam.eventscalendar.event;

import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping("/byDate/{date}")
  public ResponseEntity<List<Event>> getEventsByDate(
    @PathVariable("date") @DateTimeFormat(
      iso = DateTimeFormat.ISO.DATE
    ) Date date
  ) {
    List<Event> events = eventService.getEventsByDate(date);

    if (!events.isEmpty()) {
      return ResponseEntity.ok(events);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Event> getElementById(@PathVariable Long id) {
    Optional<Event> event = this.eventService.getById(id);

    if (event.isPresent()) {
      return new ResponseEntity<>(event.get(), HttpStatus.OK);
    } else {
      throw new Error(String.format("Event with id: %d not found", id));
    }
  }

  @PostMapping
  public ResponseEntity<Event> createEvent(
    @Valid @RequestBody EventCreateDTO data
  ) {
    Event newEvent = this.eventService.createEvent(data);
    return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Event> deleteById(@PathVariable Long id) {
    boolean deleted = this.eventService.deleteById(id);

    if (deleted == true) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    throw new Error("Event Not Found");
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Event> updateById(
    @PathVariable Long id,
    @Valid @RequestBody EventCreateDTO data
  ) {
    Optional<Event> updated = this.eventService.updateById(id, data);

    if (updated.isPresent()) {
      return new ResponseEntity<Event>(updated.get(), HttpStatus.OK);
    }

    throw new Error("Event Not Found");
  }
}
