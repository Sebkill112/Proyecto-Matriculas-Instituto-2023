package com.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.matriculas.entity.Carrera;
import com.matriculas.entity.Facultad;
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
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		model.addAttribute("carreras",serCarrera.listarCarreras());
		
		
		return "carrera";
	}
	
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("facultad") int fac,
			@RequestParam("ciclo") String cic,
			@RequestParam("creditos") int cred,
			RedirectAttributes redirect)
	{
		try {
			
			Carrera c = new Carrera();
			
			c.setCodigo(cod);
			c.setNombre(nom);
			
			Facultad f = new Facultad();
			f.setCodigo(fac);
			
			c.setFacultad(f);
			c.setCiclos(cic);
			c.setCreditos(cred);
			
			
			if(cod==0) {
				serCarrera.agregar(c);
				redirect.addFlashAttribute("MENSAJE","Carrera registrada");
			} else {
				c.setCodigo(cod);
				serCarrera.actualizar(c);
				redirect.addFlashAttribute("MENSAJE","Carrera actualizada");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/carrera/lista";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigoEliminar") Integer cod,RedirectAttributes redirect) {
		
		serCarrera.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","Libro "+cod+" eliminado");
		
		return "redirect:/carrera/lista";
	}
	
}
