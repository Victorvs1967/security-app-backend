package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.model.Announcement;

import reactor.core.publisher.Flux;

public interface AnnouncementService {
  public Flux<Announcement> getAnnouncements();
}
