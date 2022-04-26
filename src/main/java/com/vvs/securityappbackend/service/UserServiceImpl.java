package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.Dto.UserDto;
import com.vvs.securityappbackend.error.exception.UserNotFoundException;
import com.vvs.securityappbackend.mapper.UserMapper;
import com.vvs.securityappbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public Mono<UserDto> getUser(String username) {
    return userRepository.findUserByUsername(username)
      .map(userMapper::toDto)
      .switchIfEmpty(Mono.error(UserNotFoundException::new));
  }

  @Override
  public Flux<UserDto> getUsers() {
    return userRepository.findAll()
      .map(userMapper::toDto);
  }
  
}
