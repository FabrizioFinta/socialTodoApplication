package com.greenfoxacademy.socialdotoapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Todo {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  @CreationTimestamp
  private Date createdAt;
  private boolean urgent;
  private boolean done;
  
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;
  
}
