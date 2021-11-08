package com.blog.controllers;

import java.util.List;

import com.blog.models.entities.Role;
import com.blog.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
  
  @Autowired
  private RoleService roleService;
  
  @GetMapping
  public Iterable<Role> findAll() {
    return roleService.findAll();
  }

  @GetMapping("/{id}")
  public Role findOne(@PathVariable("id") Long id) {
    return roleService.findOne(id);
  }

  @GetMapping("/user/{username}")
  public List<Role> findByUsers(@PathVariable("username") String username) {
    return roleService.findByUsers(username);
  }

  @PostMapping
  public Role save(@RequestBody Role role) {
    return roleService.save(role);
  }
}
