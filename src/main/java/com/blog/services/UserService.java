package com.blog.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.blog.models.entities.User;
import com.blog.models.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Optional<User> user = userRepo.findByUsername(username);

    // user.orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
    // return user.map(MyUserDetails::new).get();

    // User user = userRepo.findByUsername(username);
    // if (user == null) {
    //   throw new UsernameNotFoundException(username);
    // }

    // return new MyUserDetails(user);

    return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found" , username)));
  }

  public User save(User user) {
    return userRepo.save(user);
  }

  public Iterable<User> findAll() {
    return userRepo.findAll();
  }

  public User findOne(Long id) {
    Optional<User> user = userRepo.findById(id);
    if (!user.isPresent()) {
      return null;
    }
    return user.get();
  }

  public User findByUsername(String username) {
    // Optional<User> user = userRepo.findByUsername(username);
    // if (!user.isPresent()) {
    //   return null;
    // }
    // return user.get();

    Optional<User> user = userRepo.findByUsername(username);
    if (user == null) {
      return null;
    }

    return user.get();
  }

  public void removeOne(Long id) {
    userRepo.deleteById(id);
  }
}
