package com.example.myapp.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("JwtTokenFilter doFilter!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        HttpServletRequest request = (HttpServletRequest) req;

        String token = getTokenFromRequest(request);

        if (token != null && jwtTokenProvider.validate(token)) {
            System.out.println("Tok.val !!!!!!!!!!!!!!!!!!!!!");
            Authentication auth = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            SecurityContextHolder.getContext().getAuthentication();
        }

        chain.doFilter(req, res);
    }
    private String getTokenFromRequest(HttpServletRequest request) {
        System.out.println("JwtTokenFilter getTokenFromRequest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // 1. Пробуем получить токен из заголовка Authorization
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            System.out.println("JwtTokenFilter getTokenFromRequest null!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            System.out.println("JwtTokenFilter getTokenFromRequest1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return authHeader.substring(7);
        }

        // 2. Если нет в заголовке, пробуем из cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            System.out.println("JwtTokenFilter getTokenFromRequest2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return Arrays.stream(cookies)
                    .filter(c -> "accessToken".equals(c.getName()))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
        }

        return null;
    }
}
