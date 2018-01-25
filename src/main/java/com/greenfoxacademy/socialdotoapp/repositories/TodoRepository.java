package com.greenfoxacademy.socialdotoapp.repositories;

import com.greenfoxacademy.socialdotoapp.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long>{
}
