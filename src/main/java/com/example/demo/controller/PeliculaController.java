package com.example.demo.controller;

import com.example.demo.model.Genero;
import com.example.demo.model.Peliculas;
import com.example.demo.service.GeneroService;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;
    
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public String listarPeliculas(Model model) {
        List<Peliculas> peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas", peliculas);
        List<Genero> generos = generoService.listarGeneros();
    	model.addAttribute("generos", generos);
        return "listarPeliculas";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
    	List<Genero> generos = generoService.listarGeneros();
    	model.addAttribute("generos", generos);
        model.addAttribute("nuevaPelicula", new Peliculas());
        return "registrarPelicula";
    }

    @PostMapping("/registrar")
    public String registrarPelicula(@ModelAttribute Peliculas nuevaPelicula, RedirectAttributes redirectAttributes) {
        peliculaService.registrarPelicula(nuevaPelicula);
        redirectAttributes.addFlashAttribute("mensaje", "Pelicula registrada correctamente");
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Peliculas pelicula = peliculaService.obtenerPeliculaPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pelicula no encontrada con ID: " + id));
        List<Genero> generos = generoService.listarGeneros();
        
    	model.addAttribute("generos", generos);
        model.addAttribute("pelicula", pelicula);
        return "editarPelicula";
    }
    
    
    @PostMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, @ModelAttribute Peliculas pelicula) {
        pelicula.setId(id);
        peliculaService.editarPelicula(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
}