package com.greenfoxacademy.socialtodoapp.repositories;

import com.greenfoxacademy.socialtodoapp.models.PublicTodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PublicTodoRepository extends CrudRepository<PublicTodo, Integer> {
}
