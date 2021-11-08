package com.blog.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

// import com.blog.models.entities.User;
import com.blog.models.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepo userRepo;

  // @Override
  // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  //   Optional<User> user = userRepo.findByUsername(username);

  //   user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
  //   return user.map(MyUserDetails::new).get();
  // }
  
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    return new User("admin", "admin", new ArrayList<>());
  }

  
  
}