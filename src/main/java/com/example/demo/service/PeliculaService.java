package com.example.demo.service;

import com.example.demo.model.Peliculas;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	public List<Peliculas> listarPeliculas() {
		return peliculaRepository.findAll();
	}

	public Optional<Peliculas> obtenerPeliculaPorId(Long id) {
		return peliculaRepository.findById(id);
	}

	public Peliculas registrarPelicula(Peliculas pelicula) {
		return peliculaRepository.save(pelicula);
	}

	public Peliculas editarPelicula(Peliculas pelicula) {
		return peliculaRepository.save(pelicula);
	}

	public void eliminarPelicula(Long id) {
		peliculaRepository.deleteById(id);
	}
}