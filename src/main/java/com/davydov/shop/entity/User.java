package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "sys_user")
public class User extends AbstractEntity {

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "first_name")
  private String first_name;

  @Column(name = "last_name")
  private String last_name;

  @Column(name = "patronymic")
  private String patronymic;

  @Column(name = "password")
  private String password;

  @ManyToMany
  @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Collection<Role> roles;

  public User() {

  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Collection<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (email != null ? !email.equals(user.email) : user.email != null) {
      return false;
    }
    if (phone != null ? !phone.equals(user.phone) : user.phone != null) {
      return false;
    }
    if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) {
      return false;
    }
    if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) {
      return false;
    }
    if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) {
      return false;
    }
    if (password != null ? !password.equals(user.password) : user.password != null) {
      return false;
    }
    return roles != null ? roles.equals(user.roles) : user.roles == null;
  }

  @Override
  public int hashCode() {
    int result = email != null ? email.hashCode() : 0;
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
    result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
    result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (roles != null ? roles.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
      "id='" + super.getId() + '\'' +
      "email='" + email + '\'' +
      ", phone='" + phone + '\'' +
      ", first_name='" + first_name + '\'' +
      ", last_name='" + last_name + '\'' +
      ", patronymic='" + patronymic + '\'' +
      ", password='" + password + '\'' +
      ", roles=" + roles +
      '}';
  }
}
