package com.sam.eventscalendar.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Events")
@Getter
@Setter
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String title;

  @Column
  private String description;

  @Column
  private String time;

  @Column
  private LocalDate date;

  public Event() {}

  public Event(String title, String description, String time, LocalDate date) {
    this.title = title;
    this.description = description;
    this.time = time;
    this.date = date;
  }
}
