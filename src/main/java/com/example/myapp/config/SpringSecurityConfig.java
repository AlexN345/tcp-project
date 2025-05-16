package com.example.myapp.config;

import com.example.myapp.security.JwtTokenFilter;
import com.example.myapp.security.UserJwtUserDetailsService;
import com.example.myapp.service.Client_serv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final Client_serv service;
    private final UserJwtUserDetailsService userDetailsService;
    private final JwtTokenFilter jwtFilter;
//    @Autowired
//    private JwtTokenRepository jwtTokenRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("SpringSecurityConfig devPasswordEncoder!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return new BCryptPasswordEncoder();  // Изменила
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.authenticationProvider(authenticationProvider());
        return builder.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // 2. Замена configure(HttpSecurity) -> SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SpringSecurityConfig securityFilterChain!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/**")) // Замена ignoringAntMatchers()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/auth/register", "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/register", "/auth/login").permitAll()
                        .requestMatchers("/css/*","/favicon.ico", "/templates/*").permitAll()
                        .anyRequest().authenticated()
                ) // Замена antMatchers()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(basic -> basic.authenticationEntryPoint((request, response, e) -> resolver.resolveException(request, response, null, e)));

        return http.build();
    }

    // 3. Замена configure(AuthenticationManagerBuilder) -> AuthenticationManager bean
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authConfig) throws Exception {
//        System.out.println("SpringSecurityConfig authenticationManager!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        return authConfig.getAuthenticationManager();
//    }
}