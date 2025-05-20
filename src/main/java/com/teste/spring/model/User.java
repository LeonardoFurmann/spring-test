package com.teste.spring.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity(name = "users")

public class User implements UserDetails {

    private String id;
    private String login;
    private String password;
    private UserRole role;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       if (this.role ==  UserRole.ADMIN) {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIM"), new SimpleGrantedAuthority("ROLE_USER"));
       } else {
         return List.of(new SimpleGrantedAuthority("ROLE_USER"));
       }


    }

    @Override
    public String getUsername() {
       return login;
    }

    
}
