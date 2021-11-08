package com.blog.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.blog.models.entities.Role;
import com.blog.models.entities.User;
import com.blog.models.repos.RoleRepo;
import com.blog.models.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
  
  @Autowired
  private RoleRepo roleRepo;

  @Autowired
  private UserRepo userRepo;

  public Role save(Role role) {
    return roleRepo.save(role);
  }

  public Iterable<Role> findAll() {
    return roleRepo.findAll();
  }

  public Role findOne(Long id) {
    Optional<Role> role = roleRepo.findById(id);
    if (!role.isPresent()) {
      return null;
    }
    return role.get();
  }

  public void removeOne(Long id) {
    roleRepo.deleteById(id);
  }

  public List<Role> findByUsers(String username) {
    // Optional<User> user = userRepo.findByUsername(username);
    return roleRepo.findByUsers_Username(username);
  }
}
