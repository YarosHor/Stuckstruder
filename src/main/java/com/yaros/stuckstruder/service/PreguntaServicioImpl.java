package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.PreguntaEntity;
import com.yaros.stuckstruder.model.PublicacionEntity;
import com.yaros.stuckstruder.repository.PreguntaRepositorio;
import com.yaros.stuckstruder.repository.PublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServicioImpl implements PreguntaServicio{

    @Autowired
    private PreguntaRepositorio repositorio;

    @Override
    public List<PreguntaEntity> listarTodosLasPreguntas() {
        return repositorio.findAll();
    }

    @Override
    public PreguntaEntity guardarPregunta(PreguntaEntity pregunta) {
        return repositorio.save(pregunta);
    }

    @Override
    public PreguntaEntity obtenerPreguntaPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public PreguntaEntity actualizarPregunta(PreguntaEntity pregunta) {
        return repositorio.save(pregunta);
    }

    @Override
    public void eliminarPregunta(Long id) {
        repositorio.deleteById(id);
    }
}
