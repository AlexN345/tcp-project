package com.example.myapp.security;

import com.example.myapp.model.Client;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class UserJwtEntity implements UserDetails {
    private final Long id;
    private final String username;
    private final String password;
    private final Collection<GrantedAuthority> authorities;

    public UserJwtEntity(Client user) {
        System.out.println("UserJwtEntity!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        this.id = user.getClientId();
        this.username = user.getPhoneNumber();
        this.password = user.getPassword();
        this.authorities = new ArrayList<>();
        System.out.println(user);
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {System.out.println("UserJwtEntity    getAuthorities!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); return authorities; }
    @Override public boolean isAccountNonExpired() {System.out.println("UserJwtEntity is!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); return true; }
    @Override public boolean isAccountNonLocked() {System.out.println("UserJwtEntity is!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); return true; }
    @Override public boolean isCredentialsNonExpired() {System.out.println("UserJwtEntity is!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); return true; }
    @Override public boolean isEnabled() {System.out.println("UserJwtEntity is!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); return true; }
}