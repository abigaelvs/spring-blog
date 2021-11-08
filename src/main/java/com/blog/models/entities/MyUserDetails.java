package com.blog.models.entities;


import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

  // private String username;
  // private String password;
  // private boolean enabled;
  // private List<GrantedAuthority> authorities;

  private User user;
  
  public MyUserDetails() {
  }

  public MyUserDetails(User user) {
    // this.username = user.getUsername();
    // this.password = user.getPassword();
    // this.enabled = user.isEnabled();
    // this.authorities = Arrays.stream(user.getTempRoles().split(","))
    //                     .map(SimpleGrantedAuthority::new)
    //                     .collect(Collectors.toList());
    this.user = user;  
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  

  // public MyUserDetails(String username) {
  //   this.user.setUsername(username);
  // }

  // @Override
  // public Collection<? extends GrantedAuthority> getAuthorities() {
  //   return authorities;
  // }

  // @Override
  // public String getPassword() {
  //   return password;
  // }

  // @Override
  // public String getUsername() {
  //   return username;
  // }

  // @Override
  // public boolean isAccountNonExpired() {
  //   return true;
  // }

  // @Override
  // public boolean isAccountNonLocked() {
  //   return true;
  // }

  // @Override
  // public boolean isCredentialsNonExpired() {
  //   return true;
  // }

  // @Override
  // public boolean isEnabled() {
  //   return enabled;
  // }

  

}