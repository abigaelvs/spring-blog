package com.blog.models.repos;

import java.util.Optional;

import com.blog.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  // @Query("SELECT * FROM user_role WHERE user_id = :userId")
  // List<Role> findAllRole(Long userId);
}
