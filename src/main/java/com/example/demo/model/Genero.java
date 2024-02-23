package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero {
    @Id
    private int idgenero;
    private String nombre;
    
    public Genero() {}
    
	public Genero(int idgenero, String nombre) {
		this.idgenero = idgenero;
		this.nombre = nombre;
	}


	public int getIdgenero() {
		return idgenero;
	}


	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
    
    
}