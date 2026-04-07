package com.chatcheck.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.chatcheck.service.UserService;
import com.chatcheck.dto.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController{

 private final UserService service;

 @PostMapping("/register")
 public String register(@RequestBody RegisterRequest req){
  return service.register(req);
 }

 @PostMapping("/login")
 public String login(@RequestBody LoginRequest req){
  return service.login(req);
 }
}
