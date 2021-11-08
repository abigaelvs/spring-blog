package com.blog.models.repos;

import java.util.List;
import java.util.Optional;

import com.blog.models.entities.Role;
import com.blog.models.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
  List<Role> findByUsers_Username(String username);
}
