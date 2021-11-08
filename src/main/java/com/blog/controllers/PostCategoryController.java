package com.blog.controllers;

import com.blog.models.entities.PostCategory;
import com.blog.services.PostCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/categories")
public class PostCategoryController {
  
  @Autowired
  private PostCategoryService postCategoryService;

  @GetMapping
  public Iterable<PostCategory> findAll() {
    return postCategoryService.findAll();
  }

  @GetMapping("/{id}")
  public PostCategory findOne(@PathVariable("id") Long id) {
    return postCategoryService.findOne(id);
  }

  @PostMapping
  public PostCategory save(@RequestBody PostCategory category) {
    return postCategoryService.save(category);
  }
}
