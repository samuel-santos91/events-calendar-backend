package com.sam.eventscalendar.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventCreateDTO {

  @NotBlank
  private String title;

  @Size(max = 100, message = "Description should not exceed 50 characters")
  private String description;

  @NotBlank
  private String time;

  @NotNull
  private LocalDate date;

  public EventCreateDTO() {}

  public EventCreateDTO(
    String title,
    String description,
    String time,
    LocalDate date
  ) {
    this.title = title;
    this.description = description;
    this.time = time;
    this.date = date;
  }
}
