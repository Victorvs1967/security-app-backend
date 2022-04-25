package com.vvs.securityappbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {

  private String username;
  private String email;
  private String role;
}
