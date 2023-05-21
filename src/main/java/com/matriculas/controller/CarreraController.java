package com.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matriculas.entity.Carrera;
import com.matriculas.service.CarreraService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private CarreraService serCarrera;
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Carrera buscarPorID(@RequestParam("codigo") Integer cod) {
		return serCarrera.BuscarCarreraPorID(cod);
	}
}
