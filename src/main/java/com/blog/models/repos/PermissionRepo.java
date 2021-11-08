package com.blog.models.repos;

import java.util.List;
import java.util.Set;

import com.blog.models.entities.Permission;

import org.springframework.data.repository.CrudRepository;

public interface PermissionRepo extends CrudRepository<Permission, Long> {
  List<Permission> findByRoles_Id(Long id);

  List<Permission> findByRoles_Name(String name);

  Set<Permission> findByRoles_Users_Username(String username);
}
