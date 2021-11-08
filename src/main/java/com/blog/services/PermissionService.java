package com.blog.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import com.blog.models.entities.Permission;
import com.blog.models.entities.Role;
import com.blog.models.repos.PermissionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PermissionService {
  
  @Autowired
  private PermissionRepo permissionRepo;

  public Permission save(Permission permission) {
    return permissionRepo.save(permission);
  }

  public Iterable<Permission> findAll() {
    return permissionRepo.findAll();
  }

  public Permission findOne(Long id) {
    Optional<Permission> permission = permissionRepo.findById(id);
    if (!permission.isPresent()) {
      return null;
    }
    return permission.get();
  }

  public void removeOne(Long id) {
    permissionRepo.deleteById(id);
  }

  public List<Permission> findByRolesId(Long id) {
    return permissionRepo.findByRoles_Id(id);
  }

  public List<Permission> findByRolesName(String name) {
    return permissionRepo.findByRoles_Name(name);
  }

  public Set<Permission> findByUsername(String username) {
    return permissionRepo.findByRoles_Users_Username(username);
  }
}
