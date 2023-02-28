package com.yaros.stuckstruder.controller;

import com.yaros.stuckstruder.model.PreguntaEntity;
import com.yaros.stuckstruder.model.PublicacionEntity;
import com.yaros.stuckstruder.service.PreguntaServicio;
import com.yaros.stuckstruder.service.PublicacionServicio;
import com.yaros.stuckstruder.service.UserDetailsImpl;
import com.yaros.stuckstruder.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublicacionControlador {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @Autowired
    private PreguntaServicio preguntaServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({ "/questions", /*"/" */})
    public String listarPreguntas(Model modelo) {
        modelo.addAttribute("publicaciones", publicacionServicio.listarTodosLasPublicaciones());
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        long id = usuarioServicio.obtenerIdUsuarioPorNombre(user.getUsername());
        System.out.println(id);
        System.out.println(usuarioServicio.obtenerUsuarioPorId(id));
        modelo.addAttribute("usuario", usuarioServicio.obtenerUsuarioPorId(id));
        return "questions"; // nos retorna al archivo estudiantes
    }

    @GetMapping("/questions/nuevo")//direccion archivo HTTPS
    public String mostrarFormularioDeRegistrtarPregunta(Model modelo) {
        PublicacionEntity publicacion = new PublicacionEntity();
        PreguntaEntity pregunta = new PreguntaEntity();
        modelo.addAttribute("pregunta", pregunta);
        return "newQuestion";//nombre archivo FS
    }

    @PostMapping("/questions")
    public String guardarPregunta(@ModelAttribute("pregunta") PreguntaEntity pregunta) {
        PublicacionEntity publicacion = new PublicacionEntity();
        publicacion.setIsQuestion((byte) 1);

        System.out.println("gaga " +pregunta.getNombre());
        System.out.println("gugu " +pregunta.getDescripcion());
        pregunta = preguntaServicio.guardarPregunta(pregunta);
        publicacion.setFkPregunta(pregunta);

        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long id = usuarioServicio.obtenerIdUsuarioPorNombre(user.getUsername());
        publicacion.setFkUsuario(usuarioServicio.obtenerUsuarioPorId(id));
        publicacionServicio.guardarPublicacion(publicacion);
        return "redirect:/questions";
    }

    @GetMapping("/questions/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        Long preguntaId = Long.valueOf(publicacionServicio.obtenerPublicacionPorId(id).getFkPregunta().getId());
        modelo.addAttribute("pregunta", preguntaServicio.obtenerPreguntaPorId(preguntaId));
        return "editQuestion";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("publicacion") PublicacionEntity publicacion, Model modelo) {
        PublicacionEntity publicacionExistente = publicacionServicio.obtenerPublicacionPorId(id);
        publicacionExistente.setId(Math.toIntExact(id));
        publicacionExistente.getFkPregunta().setId(publicacion.getFkPregunta().getId());
        publicacionExistente.getFkPregunta().setNombre(publicacion.getFkPregunta().getNombre());
        publicacionExistente.getFkPregunta().setDescripcion(publicacion.getFkPregunta().getDescripcion());
        publicacionExistente.getFkPregunta().setFechaCreacion(publicacion.getFkPregunta().getFechaCreacion());

        publicacionServicio.actualizarPublicacion(publicacionExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/questions/{id}")
    public String eliminarPregunta(@PathVariable Long id) {
        System.out.println("eliminarPubli " + id);
        //Long idPregunta = Long.valueOf(publicacionServicio.obtenerPublicacionPorId(id).getFkPregunta().getId());
        //publicacionServicio.obtenerPublicacionPorId(id).setFkPregunta(null);
        //preguntaServicio.eliminarPregunta(0L);
        publicacionServicio.eliminarPublicacion(id);
        return "redirect:/questions";
    }
}
