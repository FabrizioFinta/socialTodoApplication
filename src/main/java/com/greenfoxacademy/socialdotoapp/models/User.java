package com.greenfoxacademy.socialdotoapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
  
  @Id
  private String username;
  private String password;
  @OneToMany
  private List<Todo> todoList;
  
  public User(){
    todoList = new ArrayList<>();
  }
  
  public User(String username, String password){
    this.username = username;
    this.password = password;
    todoList = new ArrayList<>();
  }
  
}
