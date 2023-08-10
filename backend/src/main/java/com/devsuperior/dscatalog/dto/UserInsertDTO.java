package com.devsuperior.dscatalog.dto;

public class UserInsertDTO extends UserDTO {

  private static final long serialVersionUID = 1870894080L;

  private String password;

  public UserInsertDTO() {
    super();
  }

  public UserInsertDTO(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserInsertDTO password(String password) {
    setPassword(password);
    return this;
  }
}
