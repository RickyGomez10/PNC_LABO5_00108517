package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Column(name="nombre")
	@Size(message = "El campo nombre no acepta mas de 20 caracteres", max = 20)
	@NotEmpty(message = "El campo nombre no puede estar vacio")
	private String Nombre;
	
	@Column(name="apellido")
	@Size(message = "El campo apellido no acepta mas de 20 caracteres", max = 20)
	@NotEmpty(message = "El campo apellido no puede estar vacio")
	private String Apellido;
	
	@Column(name="carne")
	@Pattern(regexp= "[0-9]{8}" , message = "El campo carne no acepta mas de 20 caracteres")
	@NotEmpty(message = "El campo carne no puede estar vacio")
	private String carne;
	
	@Column(name="carrera")
	@Size(message = "El campo carrera no acepta mas de 30 caracteres", max = 30)
	@NotEmpty(message = "El campo carrera no puede estar vacio")
	private String carrera;
	
	public Estudiante() {
		
	}
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	
	
	
}
