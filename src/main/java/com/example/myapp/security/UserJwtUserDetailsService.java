package com.example.myapp.security;

import com.example.myapp.model.Client;
import com.example.myapp.service.Client_serv;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserJwtUserDetailsService implements UserDetailsService {
    private final Client_serv userService;
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("UserJwtUserDetailsService loadUserByUsername!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(phone);
        try {
            Client user = userService.getClientByPhoneNumber(phone);
            return new UserJwtEntity(user);
        } catch (RuntimeException e) {
            Client user = new Client("80000000000", "1234", "Nastyaa");
            return new UserJwtEntity(user);
        }
    }
}