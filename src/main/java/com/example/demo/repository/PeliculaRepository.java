package com.example.demo.repository;

import com.example.demo.model.Peliculas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PeliculaRepository extends JpaRepository<Peliculas, Long> {
	
}