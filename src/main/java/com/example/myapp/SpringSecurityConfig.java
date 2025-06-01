package com.example.myapp;

import com.example.myapp.config.JwtCsrfFilter;
import com.example.myapp.config.JwtTokenRepository;
import com.example.myapp.service.Client_serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private Client_serv service;

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Bean
    public PasswordEncoder devPasswordEncoder() {
        System.out.println("SpringSecurityConfig devPasswordEncoder!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return new BCryptPasswordEncoder();  // Изменила
    }

    // 2. Замена configure(HttpSecurity) -> SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SpringSecurityConfig securityFilterChain!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.NEVER))
                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/**")) // Замена ignoringAntMatchers()
                .authorizeHttpRequests(auth -> auth.requestMatchers("/register").permitAll().requestMatchers("/auth/login").authenticated()) // Замена antMatchers()
                .httpBasic(basic -> basic.authenticationEntryPoint((request, response, e) -> resolver.resolveException(request, response, null, e)));

        return http.build();
    }

    // 3. Замена configure(AuthenticationManagerBuilder) -> AuthenticationManager bean
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        System.out.println("SpringSecurityConfig authenticationManager!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return authConfig.getAuthenticationManager();
    }
}