package com.vvs.securityappbackend.repository;

import com.vvs.securityappbackend.model.User;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
  Mono<UserDetails> getUserByUsername(String username);
  Mono<User> findUserByUsername(String username);
}
