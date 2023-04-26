package com.accenture.techEventsBack.domain.models;


import com.accenture.techEventsBack.security.token.Token;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_users")
public class User implements UserDetails {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @JsonIgnore
  private String username;
  private String loginName;
  //private String photoPath; TODO
  private String firstname;
  private String firstLastname;
  private String secondLastname;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Token> tokens;

  @ManyToMany
  @JoinTable(name = "user_events",
          joinColumns = {
                  @JoinColumn(name = "user_id", referencedColumnName = "id")
          },
          inverseJoinColumns = {
                  @JoinColumn(name = "event_id", referencedColumnName = "id")
          })
  private Set<Event> signedInEvents=new HashSet<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
