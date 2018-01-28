package com.greenfoxacademy.socialtodoapp.models.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message implements DTO {
  
  String message;
  
  public Message(String message) {
    this.message = message;
  }
}
