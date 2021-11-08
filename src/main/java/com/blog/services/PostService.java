package com.blog.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.blog.models.entities.Post;
import com.blog.models.repos.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService {
  
  @Autowired
  private PostRepo postRepo;

  public Post save(Post post) {
    return postRepo.save(post);
  }

  public Iterable<Post> findAll() {
    return postRepo.findAll();
  }

  public Post findOne(Long id) {
    Optional<Post> post = postRepo.findById(id);
    if (!post.isPresent()) {
      return null;
    }
    return post.get();
  }

  public void removeOne(Long id) {
    postRepo.deleteById(id);
  }
}
