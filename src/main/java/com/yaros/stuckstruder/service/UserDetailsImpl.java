package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private UsuarioEntity user;

    public UserDetailsImpl(UsuarioEntity user) {
        System.out.println("el 1  " + user.getNombre());
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        System.out.println("Password  " + user.getContraseña());
        return user.getContraseña();
    }

    @Override
    public String getUsername() {
        System.out.println("User  " + user.getNombre());
        return user.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
