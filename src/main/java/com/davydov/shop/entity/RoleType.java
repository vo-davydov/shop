package com.davydov.shop.entity;

public enum RoleType {

  ROLE_ADMIN("ROLE_ADMIN"),
  ROLE_CUSTOMER("ROLE_CUSTOMER"),
  ROLE_MANAGER("ROLE_MANAGER");

  private String role;

  RoleType(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
