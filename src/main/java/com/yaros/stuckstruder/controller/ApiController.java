package com.yaros.stuckstruder.controller;

import com.yaros.stuckstruder.model.PreguntaEntity;
import com.yaros.stuckstruder.model.PublicacionEntity;
import com.yaros.stuckstruder.model.UsuarioEntity;
import com.yaros.stuckstruder.repository.PreguntaRepositorio;
import com.yaros.stuckstruder.repository.PublicacionRepositorio;
import com.yaros.stuckstruder.repository.UsuarioRepositorio;
import com.yaros.stuckstruder.service.PreguntaServicio;
import com.yaros.stuckstruder.service.PublicacionServicio;
import com.yaros.stuckstruder.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private PublicacionServicio publicacionServicio;

    @Autowired
    private PreguntaServicio preguntaServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/publicacion/all")
    public List<PublicacionEntity> getPublicaciones() {
        return publicacionServicio.listarTodosLasPublicaciones();
    }
    @GetMapping("/pregunta/all")
    public List<PreguntaEntity> getPreguntas() {
        return preguntaServicio.listarTodosLasPreguntas();
    }
    @GetMapping("/usuario/all")
    public List<UsuarioEntity> getUsuarios() {
        return usuarioServicio.listarTodosLosUsuarios();
    }
}
