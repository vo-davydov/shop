package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class AbstractEntity implements Serializable {
  private Long id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private LocalDateTime created;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private LocalDateTime updated;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  @Column(name = "created", updatable = false)
  public LocalDateTime getCreated() {
    return created;
  }

  @Column(name = "updated", insertable = false)
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
