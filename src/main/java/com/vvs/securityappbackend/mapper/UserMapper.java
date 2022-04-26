package com.vvs.securityappbackend.mapper;

import com.vvs.securityappbackend.Dto.UserDto;
import com.vvs.securityappbackend.model.User;

public interface UserMapper {
  UserDto toDto(User user);
  User fromDto(UserDto userDto);
}
