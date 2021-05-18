package com.davydov.shop.service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.davydov.shop.dto.RoleTypeDto;
import com.davydov.shop.dto.UserDto;
import com.davydov.shop.entity.Role;
import com.davydov.shop.entity.RoleType;
import com.davydov.shop.entity.User;
import com.davydov.shop.errors.EmptyUserException;
import com.davydov.shop.errors.RoleNotFoundException;
import com.davydov.shop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
  private PasswordEncoder passwordEncoder;

  private UserRepository userRepository;

  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
      mapRolesToAuthorities(user.getRoles()));

  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRoleType().getRole())).collect(Collectors.toList());
  }

  @Transactional
  public User registerNewUserAccount(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setRoles(getRoles(userDto));

    return userRepository.save(user);
  }

  private Collection<Role> getRoles(UserDto accountDto) {
    if (accountDto == null) {
      throw new EmptyUserException("There should not be empty user");
    }

    List<Role> roles = new ArrayList<>();
    try {
      for (RoleType role : RoleType.values()) {
        for (RoleTypeDto roleDto : accountDto.getRoles()) {
          if (role.equals(roleDto)) {
            roles.add(new Role(role));
          }
        }
      }
    } catch (RuntimeException e) {
      throw new RoleNotFoundException("Role not found");
    }

    return roles;
  }
}
