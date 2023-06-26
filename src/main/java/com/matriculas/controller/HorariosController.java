package com.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matriculas.entity.Carrera;
import com.matriculas.entity.Curso;
import com.matriculas.entity.Docente;
import com.matriculas.entity.Horario;
import com.matriculas.service.CursoService;
import com.matriculas.service.DocenteService;
import com.matriculas.service.HorarioService;

@Controller
@RequestMapping("/horariocrud")
public class HorariosController {

	@Autowired
	private HorarioService serHorario;
	
	@Autowired 
	private DocenteService serDocente;
	
	@Autowired
	private CursoService serCurso;
	
	
	@RequestMapping("/listar")
	public String lista(Model model) {
		
		model.addAttribute("docente",serDocente.listarTodos());
		model.addAttribute("curso",serCurso.listarCursos());
		model.addAttribute("horario", serHorario.listarTodos());
		
		return "horarios";
	}
	
	@RequestMapping("/grabar")
	public String GrabarInscripcion(
			@RequestParam("codigo") int codigo,
			@RequestParam("idcurso") String codcur,
			@RequestParam("iddocente") int coddoc,
			@RequestParam("turno") String turno,
			@RequestParam("vacantes") int vac,
			@RequestParam("ciclo") int ciclo,
			RedirectAttributes redirect) {
		
		try {
			
			Horario h = new Horario();
			
			Curso c = new Curso();
			c.setCodigo(codcur);
			
			h.setCurso(c);
			
			Docente d = new Docente();
			d.setCodigo(coddoc);
			
			h.setDocente(d);
			
		
			
			
			h.setTurno(turno);
			h.setVacantes(vac);
			h.setCiclo(ciclo);
						
			if(codigo == 0) {
				
				serHorario.registrar(h);
				
				redirect.addFlashAttribute("MENSAJE","Horario Grabado");
				
			} else {
				
				h.setCodigo(codigo);
				
				serHorario.actualizar(h);
				
				redirect.addFlashAttribute("MENSAJE","Horario Actualizado");
				
			}
				
				
				
			
		
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
			e.printStackTrace();
		}	
		
		return "redirect:/horariocrud/listar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigoEliminar") int cod,
			RedirectAttributes redirect) {
		
		serHorario.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","HORARIO "+cod+" eliminado");
		
		return "redirect:/horariocrud/listar";
	}
	

	@RequestMapping("/buscar")
	@ResponseBody
	public Horario buscarPorID(@RequestParam("codigo") Integer cod) {
		return serHorario.BuscarHorarioPorID(cod);
	}
	
	
}
