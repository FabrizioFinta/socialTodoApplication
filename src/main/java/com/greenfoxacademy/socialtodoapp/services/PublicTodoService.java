package com.greenfoxacademy.socialtodoapp.services;

import com.greenfoxacademy.socialtodoapp.factories.PublicTodoFactory;
import com.greenfoxacademy.socialtodoapp.models.PublicTodo;
import com.greenfoxacademy.socialtodoapp.repositories.PublicTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicTodoService {

  @Autowired
  PublicTodoRepository publicTodoRepository;
  @Autowired
  PublicTodoFactory publicTodoFactory;
  
  public void update(PublicTodo publicTodo){
    publicTodoRepository.save(publicTodo);
  }
  
  public void delete(int publicTodo){
    publicTodoRepository.delete(publicTodo);
  }
  
  public void createTodo(String title, int requiredCandidates){
    publicTodoRepository.save(publicTodoFactory.create(title, requiredCandidates));
  }
  
  public PublicTodo createAndGet(String title, int requiredCandidates){
    PublicTodo publicTodo = publicTodoFactory.create(title, requiredCandidates);
    publicTodoRepository.save(publicTodo);
    return publicTodo;
  }
  
  public List<PublicTodo> getAll(){
    return (List<PublicTodo>)publicTodoRepository.findAll();
  }
  
  public PublicTodo get(int id){
    return publicTodoRepository.findOne(id);
  }
  
}
