package com.blog.models.entities;

import java.io.Serializable;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 255)
  private String title;

  @Column(length = 255, unique = true)
  private String slug;

  @Column(length = 1000)
  private String excerpt;

  @Column(length = 10000)
  private String body;

  @ManyToOne
  private PostCategory postCategory;

  private Instant publishedAt;

  @CreatedDate
  @Column(updatable = false)
  private Instant createdAt;

  @LastModifiedDate
  private Instant updatedAt;
  
  public Post() {
  }

  public Post(Long id, String title, String slug, String excerpt, String body, Instant publishedAt, Instant createdAt,
      Instant updatedAt) {
    this.id = id;
    this.title = title;
    this.slug = slug;
    this.excerpt = excerpt;
    this.body = body;
    this.publishedAt = publishedAt;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getExcerpt() {
    return excerpt;
  }

  public void setExcerpt(String excerpt) {
    this.excerpt = excerpt;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public PostCategory getPostCategory() {
    return postCategory;
  }

  public void setPostCategory(PostCategory postCategory) {
    this.postCategory = postCategory;
  }

  public Instant getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Instant publishedAt) {
    this.publishedAt = publishedAt;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
  
  
}
