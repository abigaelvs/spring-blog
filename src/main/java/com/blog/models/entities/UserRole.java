package com.blog.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRole implements Serializable {
  
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "role_id")
  private Long roleId;
}
