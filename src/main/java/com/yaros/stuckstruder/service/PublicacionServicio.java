package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.PublicacionEntity;

import java.util.List;

public interface PublicacionServicio {
    public List<PublicacionEntity> listarTodosLasPublicaciones();

    public PublicacionEntity guardarPublicacion(PublicacionEntity publicacion);

    public PublicacionEntity obtenerPublicacionPorId(Long id);

    public PublicacionEntity actualizarPublicacion(PublicacionEntity publicacion);

    public void eliminarPublicacion(Long id);
}
