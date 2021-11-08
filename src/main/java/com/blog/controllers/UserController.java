package com.blog.controllers;

import com.blog.models.entities.User;
import com.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @GetMapping
  public Iterable<User> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public User findOne(@PathVariable("id") Long id) {
    return userService.findOne(id);
  }

  @GetMapping("/by-username/{username}")
  public User findByUsername(@PathVariable("username") String username) {
    return userService.findByUsername(username);
  }

  @PostMapping
  public User save(@RequestBody User user) {
    return userService.save(user);
  }
}
