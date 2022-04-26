package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.Dto.ResponseDto;
import com.vvs.securityappbackend.Dto.UserDto;

import reactor.core.publisher.Mono;

public interface AuthService {
  Mono<UserDto> signUp(UserDto userDto);
  Mono<ResponseDto> login(String username, String password);
}
