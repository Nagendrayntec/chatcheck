package com.chatcheck.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.chatcheck.repository.UserRepository;
import com.chatcheck.entity.User;
import com.chatcheck.dto.*;

@Service
@RequiredArgsConstructor
public class UserService{

 private final UserRepository repo;
 private final BCryptPasswordEncoder encoder;

 public String register(RegisterRequest req){
  if(repo.findByEmail(req.email).isPresent()) return "Email already exists";
  if(repo.findByUsername(req.username).isPresent()) return "Username already exists";

  User u=User.builder()
   .username(req.username)
   .email(req.email)
   .password(encoder.encode(req.password))
   .build();

  repo.save(u);
  return "Registration successful";
 }

 public String login(LoginRequest req){
  var user=repo.findByEmail(req.email);
  if(user.isEmpty()) return "Login failed";

  if(encoder.matches(req.password,user.get().getPassword())){
   return "Login successful";
  }
  return "Login failed";
 }
}
