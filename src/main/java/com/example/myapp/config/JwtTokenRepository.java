package com.example.myapp.config;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;

@Repository
public class JwtTokenRepository implements CsrfTokenRepository {
    @Value("${jwt.secret}")
    private String secret;     //можно потом добавить связь с номером телефона пользователя
    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    public JwtTokenRepository() {
        System.out.println("JwtTokenRepository!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    public String getSecret() {
        System.out.println("JwtTokenRepository    getSecret!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return secret;
    }
    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        System.out.println("JwtTokenRepository    generateToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String id = UUID.randomUUID().toString().replace("-", "");
        Date now = new Date();
        Date exp = Date.from(Instant.now().plusMillis(expirationMs));

        String token = "";
        try {
            token = Jwts.builder()
                    .setId(id)
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        } catch (JwtException e) {
            e.printStackTrace();   //не очень хорошая обработка (просто выводит ошибку в логи и возвращает пустой токен)
        }
        return new DefaultCsrfToken("x-csrf-token", "_csrf", token);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("JwtTokenRepository    saveToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (Objects.nonNull(csrfToken)) {
            /*if (!response.getHeaderNames().contains(ACCESS_CONTROL_EXPOSE_HEADERS))              //это вроде только для js
                response.addHeader(ACCESS_CONTROL_EXPOSE_HEADERS, csrfToken.getHeaderName());*/

            if (response.getHeaderNames().contains(csrfToken.getHeaderName())) {
                System.out.println("JwtTokenRepository    saveToken1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
            }
            else {
                System.out.println("JwtTokenRepository    saveToken2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                response.addHeader(csrfToken.getHeaderName(), csrfToken.getToken());
            }
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        System.out.println("JwtTokenRepository    loadToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    public void clearToken(HttpServletResponse response) {
        System.out.println("JwtTokenRepository    clearToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (response.getHeaderNames().contains("x-csrf-token"))
            response.setHeader("x-csrf-token", "");
    }
}
