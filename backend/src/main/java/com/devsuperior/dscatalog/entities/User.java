package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  private static final long serialVersionUID = 4636176657L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private String email;
  private String password;

  @ManyToMany
  @JoinTable(
    name = "tb_user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles = new HashSet<>();

  public User() {}

  public User(
    Long id,
    String firstName,
    String lastName,
    String email,
    String password
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User id(Long id) {
    setId(id);
    return this;
  }

  public User firstName(String firstName) {
    setFirstName(firstName);
    return this;
  }

  public User lastName(String lastName) {
    setLastName(lastName);
    return this;
  }

  public User email(String email) {
    setEmail(email);
    return this;
  }

  public User password(String password) {
    setPassword(password);
    return this;
  }

  public Set<Role> getRoles() {
    return this.roles;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return (
      Objects.equals(id, user.id) &&
      Objects.equals(firstName, user.firstName) &&
      Objects.equals(lastName, user.lastName) &&
      Objects.equals(email, user.email) &&
      Objects.equals(password, user.password)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, password);
  }
}
