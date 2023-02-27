package com.yaros.stuckstruder.repository;

import com.yaros.stuckstruder.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByNombre(String nombre);
}
