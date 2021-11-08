package com.blog.models.repos;

import com.blog.models.entities.PostCategory;

import org.springframework.data.repository.CrudRepository;

public interface PostCategoryRepo extends CrudRepository<PostCategory, Long> {
  
}
