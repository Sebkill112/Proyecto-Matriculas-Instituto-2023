package com.matriculas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	
	@RequestMapping("/registro")
	public String index() {
		return "";
	}
	
	
	
	
}
