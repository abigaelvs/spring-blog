package com.blog.controllers;

import java.util.Set;

import com.blog.helpers.JwtHelper;
import com.blog.models.entities.AuthenticationRequest;
import com.blog.models.entities.AuthenticationResponse;
import com.blog.models.entities.Permission;
import com.blog.services.PermissionService;
import com.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {
  
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;

  @Autowired
  private PermissionService permissionService;

  @Autowired
  private JwtHelper jwtTokenHelper;

  @PostMapping
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
  throws Exception {

    try {
      Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
      );

      System.out.println("==== AUTHENTICATION ====");
      System.out.println(authentication.getDetails());
    } catch (BadCredentialsException e) {
      throw new Exception("Incorect Username or Password");
    }

    final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
    

    final String jwt = jwtTokenHelper.generateToken(userDetails); 
    Set<Permission> permissions = permissionService.findByUsername(authRequest.getUsername());

    return ResponseEntity.ok(new AuthenticationResponse(jwt, authRequest.getUsername(), permissions));
  }
}
