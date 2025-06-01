package com.example.myapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties props;
    private SecretKey key;
    private final UserDetailsService userDetailsService;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(props.getSecret().getBytes());
    }

    public String createAccessToken(Authentication auth) {
        System.out.println("JwtTokenProvider createAccessToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        UserJwtEntity user = (UserJwtEntity) auth.getPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        System.out.println(user.getAuthorities());
        Instant now = Instant.now();
        return Jwts.builder()
            .setSubject(user.getUsername())
            .claim("id", user.getId())
            .claim("roles", user.getAuthorities())
            .setIssuedAt(Date.from(now))
            .setExpiration(Date.from(now.plus(props.getAccess(), ChronoUnit.HOURS)))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public boolean validate(String token) {
        System.out.println("JwtTokenProvider validate!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        System.out.println("JwtTokenProvider getAuthentication!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        var claims = Jwts.parserBuilder().setSigningKey(key).build()
            .parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}