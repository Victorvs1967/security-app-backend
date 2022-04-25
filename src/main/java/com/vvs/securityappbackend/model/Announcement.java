package com.vvs.securityappbackend.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Announcement {
  
  private String headline;
  private String text;
  private Date date;
}
