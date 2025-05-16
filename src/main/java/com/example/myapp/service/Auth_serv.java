package com.example.myapp.service;

import com.example.myapp.dto.auth.JwtRequest;
import com.example.myapp.dto.auth.JwtResponse;
import com.example.myapp.model.Client;
import com.example.myapp.model.Groupp;
import com.example.myapp.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Auth_serv {
  private final AuthenticationManager authManager;
  private final Client_serv userService;
  private final JwtTokenProvider jwtProvider;
  private final Groupp_serv grouppServ;

  public JwtResponse login(JwtRequest req) {
    System.out.println("!!!!!!!!!!!!!!!");
    System.out.println(req.getUsername());
    System.out.println(req.getPassword());
    Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
    );
    System.out.println("Auth_serv end1!!!!!!!!!!!!!!!");
    //UserDetails userDetails = (UserDetails)auth.getPrincipal();
    //System.out.println(userDetails.getUsername());
    Client user = userService.getClientByPhoneNumber(req.getUsername());
    System.out.println("Auth_serv end2!!!!!!!!!!!!!!!");
    return JwtResponse.builder()
            .id(user.getClientId())
            .username(user.getName())
            .accessToken(jwtProvider.createAccessToken(auth))
            .build();
  }


}
