package com.greenfoxacademy.socialdotoapp.services;

import com.greenfoxacademy.socialdotoapp.factories.UserFactory;
import com.greenfoxacademy.socialdotoapp.models.User;
import com.greenfoxacademy.socialdotoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
  
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserFactory userFactory;
  
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
  
  private boolean isExistingUser(String username) {
    return null == userRepository.findByUsername(username);
  }
  
  private boolean isInputValid(String username, String password) {
    return !(username.isEmpty() && password.isEmpty() && username == null && password == null);
  }
  
  private boolean checkPassword(String username, String password) {
    return userRepository.findByUsername(username).getPassword().equals(password);
  }
}
