package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.Dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
  Mono<UserDto> getUser(String username);
  Flux<UserDto> getUsers();
}
