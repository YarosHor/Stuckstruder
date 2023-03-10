package com.yaros.stuckstruder.controller;

import com.lowagie.text.DocumentException;
import com.yaros.stuckstruder.model.PreguntaEntity;
import com.yaros.stuckstruder.model.PublicacionEntity;
import com.yaros.stuckstruder.service.PreguntaServicio;
import com.yaros.stuckstruder.service.PublicacionServicio;
import com.yaros.stuckstruder.service.UserDetailsImpl;
import com.yaros.stuckstruder.service.UsuarioServicio;
import com.yaros.stuckstruder.util.PdfGeneratorJava;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long id = usuarioServicio.obtenerIdUsuarioPorNombre(user.getUsername());
        modelo.addAttribute("usuario", usuarioServicio.obtenerUsuarioPorId(id));
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
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUser = usuarioServicio.obtenerIdUsuarioPorNombre(user.getUsername());
        modelo.addAttribute("usuario", usuarioServicio.obtenerUsuarioPorId(idUser));
        return "editQuestion";
    }

    @PostMapping("/questions/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("pregunta") PreguntaEntity pregunta, Model modelo) {
        // preguntaEntity = preguntaServicio.obtenerPreguntaPorId(id).getPublicacion();
        PublicacionEntity publicacionExistente = preguntaServicio.obtenerPreguntaPorId(id).getPublicacion();
        publicacionExistente.getFkPregunta().setId(Math.toIntExact(id));
        publicacionExistente.getFkPregunta().setNombre(pregunta.getNombre());
        publicacionExistente.getFkPregunta().setDescripcion(pregunta.getDescripcion());
        publicacionExistente.getFkPregunta().setFechaCreacion(pregunta.getFechaCreacion());

        publicacionServicio.actualizarPublicacion(publicacionExistente);
        return "redirect:/questions";
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

    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=publicaciones" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        List< PublicacionEntity > publicacionEntityList = publicacionServicio.listarTodosLasPublicaciones();
        PdfGeneratorJava generator = new PdfGeneratorJava();
        generator.generate(publicacionEntityList, response);
    }


}
