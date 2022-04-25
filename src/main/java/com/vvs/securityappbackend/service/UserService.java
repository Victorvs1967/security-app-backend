package com.vvs.securityappbackend.service;

import java.util.ArrayList;
import java.util.List;

import com.vvs.securityappbackend.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  public List<User> getUsers() {
    return new ArrayList<>() {{
      add(User.builder()
        .username("ilovespace78")
        .email("ilovespace78@spacespace.com")
        .role("Member")
        .build());
      add(User.builder()
        .username("ilovemoon88")
        .email("ilovemoon88@moonmoon.com")
        .role("Member")
        .build());
      add(User.builder()
        .username("ilovemars98")
        .email("ilovemars98@marsmars.com")
        .role("Member")
        .build());
      add(User.builder()
        .username("Bob")
        .email("bob@spacetravels.com")
        .role("Admin")
        .build());
      add(User.builder()
        .username("Sheila")
        .email("ilovespace78@spacetravels.com")
        .role("Admin")
        .build());
      add(User.builder()
        .username("Hope")
        .email("ilovespace78@spacetravels.com")
        .role("Admin")
        .build());
    }};
  }
}
