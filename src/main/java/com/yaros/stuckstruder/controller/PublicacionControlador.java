package com.yaros.stuckstruder.controller;

import com.yaros.stuckstruder.service.PublicacionServicio;
import com.yaros.stuckstruder.service.UserDetailsImpl;
import com.yaros.stuckstruder.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicacionControlador {

    @Autowired
    private PublicacionServicio publicacionServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({ "/questions", /*"/" */})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("publicaciones", publicacionServicio.listarTodosLasPublicaciones());
        /*UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        long id = usuarioServicio.obtenerIdUsuarioPorNombre(user.getUsername());
        System.out.println(id);
        System.out.println(usuarioServicio.obtenerUsuarioPorId(id));
        modelo.addAttribute("usuario", usuarioServicio.obtenerUsuarioPorId(id));*/
        return "questions"; // nos retorna al archivo estudiantes
    }
    /*@GetMapping({ "/questions", "/" })
    public String getAutor(Model modelo) {
        modelo.addAttribute("us", servicio.listarTodosLasPublicaciones());
        return "questions"; // nos retorna al archivo estudiantes
    }*/

    /*@GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
        PublicacionEntity publicacion = new PublicacionEntity();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
                                       Model modelo) {
        Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        servicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }*/
}
