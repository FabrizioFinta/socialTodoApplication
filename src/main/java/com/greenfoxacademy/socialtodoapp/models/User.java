package com.greenfoxacademy.socialtodoapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @Cascade(CascadeType.ALL)
  private List<Todo> todoList;
  
  @ManyToMany(mappedBy = "userList")
  private List<PublicTodo> publicTodoList;
  
  public User(){
  }
  
  public User(String username, String password){
    this.username = username;
    this.password = password;
    todoList = new ArrayList<>();
  }
  
}
