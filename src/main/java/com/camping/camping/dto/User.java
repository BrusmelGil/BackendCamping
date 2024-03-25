package com.camping.camping.dto;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

  @Id
  private Integer id;

  private String username;

  private String password;


  public User() {
  }

  public User(Integer id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      " username='" + getUsername() + "'" +
      " password='" + getPassword() + "'" +
    "}";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return false;
    } 
    if (!(o instanceof User)) {
      return false;
    }
    User User = (User) o;
    return Objects.equals(id, User.id) && Objects.equals(username, User.username) && Objects.equals(password, User.password);
  }
}
