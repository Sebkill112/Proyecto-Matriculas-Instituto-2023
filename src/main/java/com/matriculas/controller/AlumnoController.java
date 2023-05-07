package com.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matriculas.service.AlumnoService;
import com.matriculas.service.DistritoService;
import com.matriculas.service.PaisService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService serAlu;
	
	@Autowired
	private DistritoService serDist;
	
	@Autowired 
	private PaisService serPais;
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("alumnos", serAlu.ListarAlumnos());
		
		return "alumno";
	}
}
