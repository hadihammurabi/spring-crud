package com.hadihammurabi.belajar.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Table(name="tasks")
public class Task {
  @Id
  @GeneratedValue
  @Column(columnDefinition="UUID")
  private UUID id;

  private String title;
  private String description;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="owner_id")
  private User owner;

  public Task() {}

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return this.id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public User getOwner() {
    return this.owner;
  }
}
