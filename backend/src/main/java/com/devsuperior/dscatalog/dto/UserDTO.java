package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDTO implements Serializable {

  private static final long serialVersionUID = -1271167675L;

  private Long id;

  @NotEmpty(message = "Campo obrigatório")
  private String firstName;

  private String lastName;

  @Email(message = "Entrar un email válido")
  private String email;

  private Set<RoleDTO> roles = new HashSet<>();

  public UserDTO() {}

  public UserDTO(Long id, String firstName, String lastName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public UserDTO(User entity) {
    id = entity.getId();
    firstName = entity.getFirstName();
    lastName = entity.getLastName();
    email = entity.getEmail();
    entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
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

  public UserDTO id(Long id) {
    setId(id);
    return this;
  }

  public UserDTO firstName(String firstName) {
    setFirstName(firstName);
    return this;
  }

  public UserDTO lastName(String lastName) {
    setLastName(lastName);
    return this;
  }

  public UserDTO email(String email) {
    setEmail(email);
    return this;
  }

  public Set<RoleDTO> getRoles() {
    return this.roles;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof UserDTO)) {
      return false;
    }
    UserDTO userDTO = (UserDTO) o;
    return (
      Objects.equals(id, userDTO.id) &&
      Objects.equals(firstName, userDTO.firstName) &&
      Objects.equals(lastName, userDTO.lastName) &&
      Objects.equals(email, userDTO.email)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email);
  }
}
