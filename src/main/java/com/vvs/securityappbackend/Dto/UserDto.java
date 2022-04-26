package com.vvs.securityappbackend.Dto;

import java.util.Date;

import com.vvs.securityappbackend.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  
  private String id;
  private String username;
  private String password;
  private String email;
  private String phone;
  private String firstName;
  private String lastName;
  private Date onCreate;
  private Date onUpdate;
  private UserRole role;

  public String fullName() {
    return firstName != null ? firstName.concat(" ").concat(lastName) : "";
  }
}
