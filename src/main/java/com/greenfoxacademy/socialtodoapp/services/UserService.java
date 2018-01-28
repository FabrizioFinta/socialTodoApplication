package com.greenfoxacademy.socialtodoapp.services;

import com.greenfoxacademy.socialtodoapp.factories.UserFactory;
import com.greenfoxacademy.socialtodoapp.models.User;
import com.greenfoxacademy.socialtodoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UserService {
  
  final UserRepository userRepository;
  final UserFactory userFactory;
  
  @Autowired
  public UserService(UserRepository userRepository, UserFactory userFactory, EntityManagerFactory entityManagerFactory) {
    this.userRepository = userRepository;
    this.userFactory = userFactory;
  }
  
  public boolean registerUser(String username, String password){
    if(isInputValid(username, password)){
      if(isExistingUser(username)){
        return false;
      }
      userRepository.save(userFactory.createUser(username, password));
      return true;
    } else {
      return false;
    }
  }
  
  public boolean logIn(String username, String password){
    if(isInputValid(username, password)){
      if(isExistingUser(username)){
        return checkPassword(username, password);
      }
    }
    return false;
  }
  
  public User getUser(String username){
    return userRepository.findByUsername(username);
  }
  
  public List<User> getAllUser(){
    return userRepository.findAll();
  }
  
  public void deleteUser(String username){
    userRepository.delete(username);
  }
  
  public void updateUser(User user){
    userRepository.save(user);
  }
  
  private boolean isExistingUser(String username) {
    return null != userRepository.findByUsername(username);
  }
  
  private boolean isInputValid(String username, String password) {
    return !(username.isEmpty() && password.isEmpty() && username == null && password == null);
  }
  
  private boolean checkPassword(String username, String password) {
    return userRepository.findByUsername(username).getPassword().equals(password);
  }
}
