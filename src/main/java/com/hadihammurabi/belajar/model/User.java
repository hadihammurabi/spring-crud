package com.hadihammurabi.belajar.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue
  @Column(columnDefinition="UUID")
  private UUID id;

  private String username;
  private String password;

  public User() {}

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return this.id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }
}
