package com.vvs.securityappbackend.repository;

import com.vvs.securityappbackend.model.Announcement;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends ReactiveMongoRepository<Announcement, String> {
  
}
