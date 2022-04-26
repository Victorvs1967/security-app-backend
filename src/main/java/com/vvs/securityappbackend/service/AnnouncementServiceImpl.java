package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.model.Announcement;
import com.vvs.securityappbackend.repository.AnnouncementRepository;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;

public class AnnouncementServiceImpl implements AnnouncementService {

  @Autowired
  private AnnouncementRepository announcementRepository;

  @Override
  public Flux<Announcement> getAnnouncements() {
    return announcementRepository.findAll();
  }
  
}
