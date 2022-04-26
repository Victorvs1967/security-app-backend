package com.vvs.securityappbackend.router;

import com.vvs.securityappbackend.Dto.ResponseDto;
import com.vvs.securityappbackend.Dto.UserDto;
import com.vvs.securityappbackend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class AuthHandler {

  @Autowired
  private AuthService authService;
  
  public Mono<ServerResponse> signUp(ServerRequest request) {
    Mono<UserDto> userDto = request.bodyToMono(UserDto.class)
      .flatMap(credentials -> authService.signUp(credentials)
      .map(userDetails -> userDetails));
      
    return ServerResponse
      .ok()
      .contentType(APPLICATION_JSON)
      .body(userDto, UserDto.class);
  }
  
  public Mono<ServerResponse> login(ServerRequest request) {
    Mono<?> response = request.bodyToMono(UserDto.class)
      .flatMap(credentials -> authService.login(credentials.getUsername(), credentials.getPassword())
      .map(responseDto -> responseDto.getData()));

    return ServerResponse
      .ok()
      .contentType(APPLICATION_JSON)
      .body(response, ResponseDto.class);
  }
}
