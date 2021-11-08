package com.blog.controllers;

import com.blog.models.entities.Post;
import com.blog.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  
  @Autowired
  private PostService postService;
  
  @GetMapping
  public Iterable<Post> findAll() {
    return postService.findAll();
  }

  @GetMapping("/{id}")
  public Post findOne(@PathVariable("id") Long id) {
    return postService.findOne(id);
  }

  @PostMapping
  public Post save(@RequestBody Post post) {
    return postService.save(post);
  }

  @PutMapping()
  public Post update(@RequestBody Post post) {
    return postService.save(post);
  }

  @DeleteMapping("/{id}")
  public void remove(@PathVariable("id") Long id) {
    postService.removeOne(id);
  }
}
