package com.greenfoxacademy.socialtodoapp.factories;

import com.greenfoxacademy.socialtodoapp.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
  
  public User createUser(String userName, String password){
    User user = new User(userName, password);
    return user;
  }
  
}
