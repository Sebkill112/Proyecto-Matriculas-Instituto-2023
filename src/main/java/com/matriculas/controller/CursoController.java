package com.matriculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matriculas.entity.Carrera;
import com.matriculas.entity.Curso;
import com.matriculas.service.CarreraService;
import com.matriculas.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	@Autowired
    private CursoService serCurso;
    @Autowired
    private CarreraService serCarrera;
    
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		model.addAttribute("curso",serCurso.listarCursos());
		model.addAttribute("carrera", serCarrera.listarCarreras());
		
		
		return "curso";
	}
	public int indice(String cod) {
		List<Curso> lista = serCurso.listarCursos();
		int resu = -1;
		String d = cod;
		for(int i=0;i<lista.size();i++) {		
			if(lista.get(i).getCodigo().equals(cod)) {
				resu = i;
			}
		}
		return resu;
	}
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") String cod,
			@RequestParam("nombre") String nom,
			@RequestParam("descripcion") String des,
			@RequestParam("carrera") Integer car,
			@RequestParam("ciclo") String cic,
			RedirectAttributes redirect)
	{
		try {
			
			Curso c = new Curso();
			
			c.setCodigo(cod);
			c.setNombre(nom);
			c.setDescripcion(des);
			Carrera ca = new Carrera();
			ca.setCodigo(car);
			
			c.setCarrera(ca);
			c.setCiclo(cic);
			int indice=indice(cod);
			
			if(indice==-1) {
				serCurso.agregar(c);
				redirect.addFlashAttribute("MENSAJE","Curso registrado");
			} else {
				c.setCodigo(cod);
				serCurso.actualizar(c);
				redirect.addFlashAttribute("MENSAJE","Curso actualizado");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/curso/lista";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Curso Buscarporid(@RequestParam("codigo") String cod) {
		return serCurso.BuscarCarreraPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigoEliminar") String cod,RedirectAttributes redirect) {
		
		serCurso.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","Curso "+cod+" eliminado");
		
		return "redirect:/curso/lista";
	}
}
