package com.greenfoxacademy.socialdotoapp.factories;

import com.greenfoxacademy.socialdotoapp.models.User;

public class UserFactory {
  
  public User createUser(String userName, String password){
    User user = new User(userName, password);
    return user;
  }
  
}
