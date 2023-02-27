package com.yaros.stuckstruder.controller;

import com.yaros.stuckstruder.service.PublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewPublicacionControlador {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @GetMapping({ "/newQuestion"})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("publicaciones", publicacionServicio.listarTodosLasPublicaciones());
        //modelo.addAttribute("usuarios", usuarioServicio.listarTodosLosUsuarios());*/
        return "subPages/newQuestion"; // nos retorna al archivo estudiantes
    }
}
