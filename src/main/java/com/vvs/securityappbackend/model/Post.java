package com.vvs.securityappbackend.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Post {
  
  private String text;
  private Date date;
  private String user;
}
