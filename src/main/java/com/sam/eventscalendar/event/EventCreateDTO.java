package com.sam.eventscalendar.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventCreateDTO {

  @NotBlank
  private String title;

  @Size(max = 50, message = "Description should not exceed 50 characters")
  private String description;

  @NotBlank
  private String time;

  public EventCreateDTO() {}

  public EventCreateDTO(String title, String description, String time) {
    this.title = title;
    this.description = description;
    this.time = time;
  }
}
