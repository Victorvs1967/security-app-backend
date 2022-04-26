package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.Dto.ResponseDto;
import com.vvs.securityappbackend.Dto.UserDto;
import com.vvs.securityappbackend.error.exception.UserAlreadyExistException;
import com.vvs.securityappbackend.error.exception.WrongCredentialException;
import com.vvs.securityappbackend.mapper.UserMapper;
import com.vvs.securityappbackend.repository.UserRepository;
import com.vvs.securityappbackend.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private PasswordEncoder passwordEncoder;  
  @Autowired
  private UserRepository userRepository;  
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private UserMapper userMapper;

  @Override
  public Mono<UserDto> signUp(UserDto userDto) {
    return isUserExist(userDto.getUsername())
      .filter(userExist -> !userExist)
      .switchIfEmpty(Mono.error(UserAlreadyExistException::new))
      .map(aBoolean -> userDto)
      .map(userMapper::fromDto)
      .doOnNext(user -> user.setPassword(passwordEncoder.encode(user.getPassword())))
      .flatMap(userRepository::save)
      .map(userMapper::toDto);
  }

  @Override
  public Mono<ResponseDto> login(String username, String password) {
    return userRepository.findUserByUsername(username)
      .filter(userDetails -> passwordEncoder.matches(password, userDetails.getPassword()))
      .map(userDetails -> jwtUtil.generateToken(userDetails))
      .map(token -> ResponseDto.builder().data(token).build())
      .switchIfEmpty(Mono.error(WrongCredentialException::new));
  }

  private Mono<Boolean> isUserExist(String username) {
    return userRepository.findUserByUsername(username)
      .map(user -> true)
      .switchIfEmpty(Mono.just(false));
  }
  
}
