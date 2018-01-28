package com.greenfoxacademy.socialtodoapp.factories;

import com.greenfoxacademy.socialtodoapp.models.PublicTodo;
import org.springframework.stereotype.Component;

@Component
public class PublicTodoFactory {
  
  public PublicTodo create(String title, int requiredCandidates){
    PublicTodo publicTodo = new PublicTodo(title, requiredCandidates);
    return publicTodo;
  }
  
}
