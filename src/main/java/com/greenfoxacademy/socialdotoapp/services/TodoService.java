package com.greenfoxacademy.socialdotoapp.services;

import com.greenfoxacademy.socialdotoapp.models.Todo;
import com.greenfoxacademy.socialdotoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoService {
  
  @Autowired
  TodoRepository todoRepository;
  
  public Todo getTodo(long id) {
    return todoRepository.findOne(id);
  }
  
  public List<Todo> getAllTodo() {
    return (List<Todo>) todoRepository.findAll();
  }
  
  public void addTodo(Todo todo) {
    todoRepository.save(todo);
  }
  
  public void deleteTodo(long id) {
    todoRepository.delete(id);
  }
  
  public void modifyTodo(Todo todo) {
    todoRepository.save(todo);
  }
}
