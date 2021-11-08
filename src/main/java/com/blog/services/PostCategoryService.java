package com.blog.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.blog.models.entities.PostCategory;
import com.blog.models.repos.PostCategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostCategoryService {
  
  @Autowired
  private PostCategoryRepo postCategoryRepo;

  public PostCategory save(PostCategory category) {
    return postCategoryRepo.save(category);
  }

  public Iterable<PostCategory> findAll() {
    return postCategoryRepo.findAll();
  }

  public PostCategory findOne(Long id) {
    Optional<PostCategory> category =  postCategoryRepo.findById(id);
    if (!category.isPresent()) {
      return null;
    }
    return category.get();
  }

  public void removeOne(Long id) {
    postCategoryRepo.deleteById(id);
  }
}
