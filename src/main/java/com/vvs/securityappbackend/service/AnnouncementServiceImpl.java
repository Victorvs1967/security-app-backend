package com.vvs.securityappbackend.service;

import java.time.Instant;
import java.util.Date;

import com.vvs.securityappbackend.model.Announcement;
import com.vvs.securityappbackend.repository.AnnouncementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

  @Autowired
  private AnnouncementRepository announcementRepository;

  @Override
  public Flux<Announcement> getAnnouncements() {
    return announcementRepository.findAll();
  }

  @Override
  public Mono<Announcement> addAnnouncement(Announcement announcement) {
    Announcement newAnnouncement = Announcement.builder()
      .headline(announcement.getHeadline())
      .text(announcement.getText())
      .date(Date.from(Instant.now()))
      .build();
    return announcementRepository.save(newAnnouncement);
  }
  
}
