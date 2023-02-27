package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.UsuarioEntity;
import com.yaros.stuckstruder.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio userRepo;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        System.out.println(userRepo.findByNombre(nombre));
        UsuarioEntity user = userRepo.findByNombre(nombre);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user);
    }

}
