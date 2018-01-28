package com.greenfoxacademy.socialtodoapp.controllers.restcontrollers;

import com.greenfoxacademy.socialtodoapp.models.DTO.DTO;
import com.greenfoxacademy.socialtodoapp.models.DTO.Message;
import com.greenfoxacademy.socialtodoapp.models.PublicTodo;
import com.greenfoxacademy.socialtodoapp.models.Todo;
import com.greenfoxacademy.socialtodoapp.models.User;
import com.greenfoxacademy.socialtodoapp.services.PublicTodoService;
import com.greenfoxacademy.socialtodoapp.services.TodoService;
import com.greenfoxacademy.socialtodoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginControllerREST {
  
  @Autowired
  UserService userService;
  @Autowired
  TodoService todoService;
  @Autowired
  PublicTodoService publicTodoService;
  
  @PostMapping ("try")
  public DTO tryAddUserAndTodo(){
    if(!userService.registerUser("First User", "extrasafepassword")){
      return new Message("error");
    }
    User user = userService.getUser("First User");
    todoService.createAndGet("First Todo").setUser(user);
    userService.updateUser(user);
    userService.registerUser("Second User", "asdasd");
    User user2 = userService.getUser("Second User");
    PublicTodo publicTodo = publicTodoService.createAndGet("First Public Todo",2);
    publicTodo.addUser(user);
    publicTodo.addUser(user2);
    publicTodoService.update(publicTodo);
    return new Message("Done");
  }
  
  @GetMapping ("getAll")
  public User getInfo(){
    return userService.getUser("First User");
  }
  
  @GetMapping("getAllTodo")
  public List<Todo> getTodoInfo(){
    return todoService.getAllTodo();
  }
}
