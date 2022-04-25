package com.vvs.securityappbackend.controller;

import java.util.List;

import com.vvs.securityappbackend.model.Announcement;
import com.vvs.securityappbackend.service.AnnouncementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
  
  @Autowired
  private AnnouncementService announcementService;

  @GetMapping("/")
  public List<Announcement> getAnnoncements() {
    return announcementService.getAnnouncements();
  }
}
