package com.matriculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matriculas.entity.Horario;
import com.matriculas.service.HorarioService;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private HorarioService serHorario;
	
	@RequestMapping("/registro")
	public String index() {
		return "DetalleMatricula";
	}
	
	@RequestMapping("/listar")
	@ResponseBody
	public List<Horario> listadoHorario(@RequestParam("turno")String turno,@RequestParam("ciclo") int ciclo){
		return serHorario.listarHorariosFiltro(turno, ciclo);
	}
	
	
	
	
}
