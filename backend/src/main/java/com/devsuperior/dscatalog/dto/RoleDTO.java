package com.devsuperior.dscatalog.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.dscatalog.entities.Role;

public class RoleDTO implements Serializable {

  private static final long serialVersionUID = -9056667207L;

  private Long id;
  private String authority;

  public RoleDTO() {}

  public RoleDTO(Long id, String authority) {
    this.id = id;
    this.authority = authority;
  }

  public RoleDTO(Role entity) {
    id = entity.getId();
    authority = entity.getAuthority();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthority() {
    return this.authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public RoleDTO id(Long id) {
    setId(id);
    return this;
  }

  public RoleDTO authority(String authority) {
    setAuthority(authority);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof RoleDTO)) {
      return false;
    }
    RoleDTO roleDTO = (RoleDTO) o;
    return (
      Objects.equals(id, roleDTO.id) &&
      Objects.equals(authority, roleDTO.authority)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, authority);
  }
}
