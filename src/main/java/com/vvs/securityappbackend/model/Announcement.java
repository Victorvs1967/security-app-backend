package com.vvs.securityappbackend.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document("announcements")
public class Announcement {
  
  @Id
  private String id;
  private String headline;
  private String text;
  private Date date;
}
