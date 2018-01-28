package com.greenfoxacademy.socialtodoapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PublicTodo {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  @CreationTimestamp
  private Date createdAt;
  private boolean urgent;
  private boolean done;
  private Integer numOfCandidateReq;
  @ManyToMany
  private List<User> userList = new ArrayList<>();
  
  public PublicTodo(String title, int requiredCandidates) {
  }
  
  public void addUser(User user){
    userList.add(user);
  }
  
}
