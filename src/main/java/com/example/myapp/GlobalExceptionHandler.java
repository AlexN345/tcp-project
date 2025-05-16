package com.example.myapp;

import com.example.myapp.config.JwtTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private JwtTokenRepository tokenRepository;

    public GlobalExceptionHandler(JwtTokenRepository tokenRepository) {
        System.out.println("GlobalExceptionHandler!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        this.tokenRepository = tokenRepository;
    }

    @ExceptionHandler({BadCredentialsException.class,MissingCsrfTokenException.class, InvalidCsrfTokenException.class, SessionAuthenticationException.class})
    public ErrorInfo handleAuthenticationException(RuntimeException ex, HttpServletRequest request, HttpServletResponse response){
        System.out.println("GlobalExceptionHandler    handleAuthenticationException!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        this.tokenRepository.clearToken(response);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return new ErrorInfo(UrlUtils.buildFullRequestUrl(request), "error.authorization");
    }


    public class ErrorInfo {
        private final String url;
        private final String info;

        ErrorInfo(String url, String info) {
            System.out.println("ErrorInfo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            this.url = url;
            this.info = info;
        }
        public String getUrl() {
            return url;
        }

        public String getInfo() {
            return info;
        }

    }
}
