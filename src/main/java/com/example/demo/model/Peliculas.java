package com.example.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pelicula")
public class Peliculas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String director;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEstreno;
    private Long idgenero;

    // Constructor, getters y setters

    public Peliculas() {
        // Constructor por defecto necesario para JPA
    }

    public Peliculas(Long id, String nombre, String director, Date fechaEstreno, Long idgenero) {
    	this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.idgenero = idgenero;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Long getIdgenero() {
		return idgenero;
	}

	public void setIdgenero(Long idgenero) {
		this.idgenero = idgenero;
	}
}