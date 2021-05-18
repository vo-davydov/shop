package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class AbstractEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  @Column(name = "create_date", updatable = false)
  private LocalDateTime created;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  @Column(name = "update_date", insertable = false)
  private LocalDateTime updated;


  public LocalDateTime getCreated() {
    return created;
  }


  public LocalDateTime getUpdated() {
    return updated;
  }

  @PrePersist
  public void toCreate() {
    setCreated(LocalDateTime.now());
  }

  @PreUpdate
  public void toUpdate() {
    setUpdated(LocalDateTime.now());
  }

  public AbstractEntity() {

  }

  public AbstractEntity(Long id, LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.created = created;
    this.updated = updated;
  }

  public AbstractEntity(LocalDateTime created, LocalDateTime updated) {
    this.created = created;
    this.updated = updated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }
}
