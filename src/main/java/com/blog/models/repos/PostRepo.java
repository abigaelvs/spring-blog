package com.blog.models.repos;

import com.blog.models.entities.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
   
}
