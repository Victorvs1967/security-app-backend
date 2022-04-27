package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.model.Announcement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnnouncementService {
  public Flux<Announcement> getAnnouncements();
  public Mono<Announcement> addAnnouncement(Announcement announcement);
}
