package com.vvs.securityappbackend.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vvs.securityappbackend.model.Announcement;

import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {
  
  public List<Announcement> getAnnouncements() {
    Instant now = Instant.now();
    return new ArrayList<>() {{
      add(Announcement.builder()
        .headline("Important Announcement!")
        .text("We are going to fly to Mars.")
        .date(Date.from(now))
        .build());
      add(Announcement.builder()
        .headline("Important Announcement!")
        .text("We are goin to to fly to the moon.")
        .date(Date.from(now.minus(1, ChronoUnit.DAYS)))
        .build());
      add(Announcement.builder()
        .headline("Important Announcement!")
        .text("We are going to fly to stace.")
        .date(Date.from(now.minus(2, ChronoUnit.DAYS)))
        .build());
    }};
  }
}
