package com.greenfoxacademy.socialtodoapp.repositories;

import com.greenfoxacademy.socialtodoapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, String> {
  List<User> findAll();
  User findByUsername(String username);
}
