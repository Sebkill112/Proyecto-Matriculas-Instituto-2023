package com.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matriculas.service.InscripcionService;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionController {
	
	@Autowired
	InscripcionService servicio;

	@RequestMapping("/registro")
	public String registro(Model model) {
		model.addAttribute("codigo",servicio.GenerarCodigo());
		return "inscripcion";
	}
}
