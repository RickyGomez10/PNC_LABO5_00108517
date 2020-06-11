package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteService {

	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void insertar(Estudiante estudiante) throws DataAccessException;
	
	public void eliminar(Integer codigo) throws DataAccessException;

}
