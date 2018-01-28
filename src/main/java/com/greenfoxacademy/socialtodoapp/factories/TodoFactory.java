package com.greenfoxacademy.socialtodoapp.factories;

import com.greenfoxacademy.socialtodoapp.models.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoFactory {
  
  public Todo createAnemptyTodo(String title){
    return new Todo(title);
  }
  
}
