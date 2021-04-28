package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_roles")
public class Role extends AbstractEntity {
  @Column(name = "role_type")
  private RoleType roleType;

  public Role(RoleType roleType) {
    this.roleType = roleType;
  }

  public RoleType getRoleType() {
    return roleType;
  }

  public void setRoleType(RoleType roleType) {
    this.roleType = roleType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Role role = (Role) o;

    return roleType == role.roleType;
  }

  @Override
  public int hashCode() {
    return roleType != null ? roleType.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Role{" +
      "id='" + super.getId() + '\'' +
      "roleType=" + roleType +
      '}';
  }
}
