package com.accenture.techEventsBack.security.auth;

import com.accenture.techEventsBack.domain.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String firstName;
  private Role role;
  private String email;
}
