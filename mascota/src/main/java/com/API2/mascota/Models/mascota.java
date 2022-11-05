package com.API2.mascota.Models;

import java.io.File;
import java.sql.Array;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="mascota")

public class mascota {
	
	
	@Getter @Setter @Column(name= "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
    @Getter @Setter @Column(name= "nombre")
	private String nombre;
	
    @Getter @Setter @Column(name= "apellido")
	private String apellido;
	
    @Getter @Setter @Column(name= "edad")
	private int edad;
	
    @Getter @Setter @Column(name= "imagen")
	private String imagen;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
    
    

}
