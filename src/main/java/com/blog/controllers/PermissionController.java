package com.blog.controllers;

import java.util.List;
import java.util.Set;

import com.blog.models.entities.Permission;
import com.blog.services.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
  
  @Autowired
  private PermissionService permissionService;
  
  @GetMapping
  public Iterable<Permission> findAll() {
    return permissionService.findAll();
  }

  @GetMapping("/{id}")
  public Permission findOne(@PathVariable("id") Long id) {
    return permissionService.findOne(id);
  }

  @GetMapping("/roles/id/{id}")
  public List<Permission> findByRoles(@PathVariable("id") Long id) {
    return permissionService.findByRolesId(id);
  }

  @GetMapping("/roles/name/{name}")
  public List<Permission> findByRolesName(@PathVariable("name") String name) {
    return permissionService.findByRolesName(name);
  }

  @GetMapping("/roles/username/{username}")
  public Set<Permission> findByUsername(@PathVariable("username") String username) {
    return permissionService.findByUsername(username);
  }

  @PostMapping
  public Permission save(@RequestBody Permission permission) {
    return permissionService.save(permission);
  }
}
