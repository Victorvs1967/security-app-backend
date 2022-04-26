package com.vvs.securityappbackend.mapper;

import java.time.Instant;
import java.util.Date;

import com.vvs.securityappbackend.Dto.UserDto;
import com.vvs.securityappbackend.model.User;
import com.vvs.securityappbackend.model.UserRole;

import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

  @Override
  public UserDto toDto(User user) {
    return UserDto.builder()
      .username(user.getUsername())
      .password(user.getPassword())
      .email(user.getEmail())
      .phone(user.getPhone())
      .firstName(user.getFirstName())
      .lastName(user.getLastName())
      .onCreate(user.getOnCreate())
      .role(user.getRole())
      .build();

  }

  @Override
  public User fromDto(UserDto userDto) {
    return User.builder()
      .username(userDto.getUsername())
      .password(userDto.getPassword())
      .email(userDto.getEmail())
      .phone(userDto.getPhone())
      .firstName(userDto.getFirstName())
      .lastName(userDto.getLastName())
      .onCreate(userDto.getOnCreate() != null ? userDto.getOnCreate() : Date.from(Instant.now()))
      .onUpdate(Date.from(Instant.now()))
      .isActive(true)
      .role(userDto.getRole() != null ? userDto.getRole() : UserRole.USER)
      .build();
  }
  
}
