package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.dao.EstudianteDAOImpl;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		Estudiante estudiante2 = new Estudiante();
		
		List<Estudiante>  estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("estudiante",estudiante);
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("index");
		
		return mav;
	}
	
	
	
	//Mostrar lista de Estudiantes                     
	@RequestMapping("/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante>  estudiantes = null;
		try {
			estudiantes = estudianteService.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
		
	}
	
	
	@RequestMapping(value="/Validar", method = RequestMethod.POST)
		public ModelAndView insertar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(!result.hasErrors()) {
			
			
		try {
			estudianteService.insertar(estudiante);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		estudiante = new Estudiante();
		mav.addObject("estudiante",estudiante);
			
		}
		
		mav.setViewName("index"); 
		return mav;
	}
	@RequestMapping(value="/eliminado", method= RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();

		Estudiante estudiante = null;
		try {
		//estudiante = estudianteService.findOne(id);
		estudianteService.eliminar(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante",estudiante);
		
		mav.setViewName("eliminado");
		return mav;
	}
		
	@RequestMapping("/modificar")
	public ModelAndView initMain2(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		try {
			estudiante = estudianteService.findOne(estudiante.getCodigoEstudiante());
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", estudiante);
		mav.setViewName("Modificar");
		return mav;
		
	}
	
	@RequestMapping(value="/Modificado", method = RequestMethod.POST)
	public ModelAndView modificar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
	ModelAndView mav = new ModelAndView();
	List<Estudiante>  estudiantes = null;
	if(!result.hasErrors()) {
		
		
	try {
		estudianteService.insertar(estudiante);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	estudiante = new Estudiante();
	mav.addObject("estudiante",estudiante);
		
		
	}
	
	mav.setViewName("Modificar"); 
	return mav;
}
		
	
}
