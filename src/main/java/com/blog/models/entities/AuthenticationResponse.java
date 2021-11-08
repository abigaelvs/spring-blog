package com.blog.models.entities;

import java.util.Set;

public class AuthenticationResponse {
  private final String jwt;
  private final String username;
  private final Set<Permission> permissions;

  public AuthenticationResponse(String jwt, String username, Set<Permission> permissions) {
    this.jwt = jwt;
    this.username = username;
    this.permissions = permissions;
  }


  public String getJwt() {
    return jwt;
  }
  public String getUsername() {
    return username;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }
  
}
