package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.UsuarioEntity;
import com.yaros.stuckstruder.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<UsuarioEntity> listarTodosLosUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public UsuarioEntity guardarUsuario(UsuarioEntity usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public UsuarioEntity obtenerUsuarioPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public long obtenerIdUsuarioPorNombre(String nombre) {
        return repositorio.findByNombre(nombre).getId();
    }

    @Override
    public UsuarioEntity actualizarUsuarios(UsuarioEntity usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }
}
