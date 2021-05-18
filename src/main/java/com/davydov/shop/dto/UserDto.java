package com.davydov.shop.dto;

import java.util.Set;
import lombok.Data;

@Data
public class UserDto {
  private String username;
  private String password;
  private Set<RoleTypeDto> roles;
}
