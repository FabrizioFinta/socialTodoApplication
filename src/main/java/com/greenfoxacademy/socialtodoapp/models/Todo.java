package com.greenfoxacademy.socialtodoapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Todo {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  @CreationTimestamp
  private Date createdAt;
  private boolean urgent;
  private boolean done;
  
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
  
  public Todo(String title) {
    this.title = title;
  }
}
