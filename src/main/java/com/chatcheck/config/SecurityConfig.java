package com.chatcheck.config;

import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig{
 @Bean
 public BCryptPasswordEncoder encoder(){
  return new BCryptPasswordEncoder();
 }
}