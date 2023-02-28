package com.yaros.stuckstruder.service;

import com.yaros.stuckstruder.model.PreguntaEntity;

import java.util.List;

public interface PreguntaServicio {
    public List<PreguntaEntity> listarTodosLasPreguntas();

    public PreguntaEntity guardarPregunta(PreguntaEntity pregunta);

    public PreguntaEntity obtenerPreguntaPorId(Long id);

    public PreguntaEntity actualizarPregunta(PreguntaEntity pregunta);

    public void eliminarPregunta(Long id);
}
