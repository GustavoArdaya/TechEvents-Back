package com.accenture.techEventsBack.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String username;
  private String loginName;
  private String firstname;
  private String firstLastname;
  private String secondLastname;
  private String email;
  private String password;
}
