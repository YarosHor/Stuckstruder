package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.PublicacionEntity;
import com.yaros.stuckstruder.repository.PublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServicioImpl implements PublicacionServicio{

    @Autowired
    private PublicacionRepositorio repositorio;

    @Override
    public List<PublicacionEntity> listarTodosLasPublicaciones() {
        return repositorio.findAll();
    }

    @Override
    public PublicacionEntity guardarPublicacion(PublicacionEntity publicacion) {
        return repositorio.save(publicacion);
    }

    @Override
    public PublicacionEntity obtenerPublicacionPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public PublicacionEntity actualizarPublicacion(PublicacionEntity publicacion) {
        return repositorio.save(publicacion);
    }

    @Override
    public void eliminarPublicacion(Long id) {
        System.out.println("IntentoEliminacion " + id);
        repositorio.deleteById(id);
    }
}
