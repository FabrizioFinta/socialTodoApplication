package com.greenfoxacademy.socialtodoapp.repositories;

import com.greenfoxacademy.socialtodoapp.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TodoRepository extends CrudRepository<Todo, Long>{
}
