package com.vvs.securityappbackend.router;

import com.vvs.securityappbackend.Dto.UserDto;
import com.vvs.securityappbackend.security.JwtUtil;
import com.vvs.securityappbackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class UserHandler {

  @Autowired
  private UserService userService;
  @Autowired
  private JwtUtil jwtUtil;
  
  public Mono<ServerResponse> getUser(ServerRequest request) {
    String token = request.headers().firstHeader("authorization").substring(7);
    Mono<UserDto> userDto = jwtUtil.getAllClaimsFromToken(token)
      .flatMap(credentials -> userService.getUser(credentials.getSubject()))
      .map(userDetails -> userDetails);

    return ServerResponse
      .ok()
      .contentType(APPLICATION_JSON)
      .body(userDto, UserDto.class);
  }
}
