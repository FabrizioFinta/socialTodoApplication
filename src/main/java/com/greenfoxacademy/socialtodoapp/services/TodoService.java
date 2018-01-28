package com.greenfoxacademy.socialtodoapp.services;

import com.greenfoxacademy.socialtodoapp.factories.TodoFactory;
import com.greenfoxacademy.socialtodoapp.models.Todo;
import com.greenfoxacademy.socialtodoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
  
  final TodoFactory todoFactory;
  final TodoRepository todoRepository;
  
  @Autowired
  public TodoService(TodoFactory todoFactory, TodoRepository todoRepository) {
    this.todoFactory = todoFactory;
    this.todoRepository = todoRepository;
  }
  
  public Todo getTodo(long id) {
    return todoRepository.findOne(id);
  }
  
  public List<Todo> getAllTodo() {
    return (List<Todo>) todoRepository.findAll();
  }
  
  public void add(Todo todo) {
    todoRepository.save(todo);
  }
  
  public void delete(long id) {
    todoRepository.delete(id);
  }
  public void update(Todo todo) {
    todoRepository.save(todo);
  }
  
  public Todo createAndGet(String title){
    Todo todo = todoFactory.createAnemptyTodo(title);
    todoRepository.save(todo);
    return todo;
  }
}

