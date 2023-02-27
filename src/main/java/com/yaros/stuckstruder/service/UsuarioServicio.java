package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.UsuarioEntity;

import java.util.List;

public interface UsuarioServicio {
    public List<UsuarioEntity> listarTodosLosUsuarios();

    public UsuarioEntity guardarUsuario(UsuarioEntity usuario);

    public UsuarioEntity obtenerUsuarioPorId(Long id);

    public long obtenerIdUsuarioPorNombre(String nombre);

    public UsuarioEntity actualizarUsuarios(UsuarioEntity usuario);

    public void eliminarUsuario(Long id);
}
