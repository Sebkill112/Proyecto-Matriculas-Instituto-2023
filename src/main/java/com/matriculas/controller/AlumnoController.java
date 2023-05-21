package com.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matriculas.entity.Alumno;
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
	
	@RequestMapping("buscar")
	@ResponseBody
	public Alumno BuscarPorId(@RequestParam("dni") String dni) {
		return serAlu.BuscarAlumnoPorCodigo(dni);
	}
}
