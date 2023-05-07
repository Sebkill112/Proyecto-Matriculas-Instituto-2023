package com.matriculas.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.matriculas.entity.Docente;
import com.matriculas.service.DocenteService;


@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	private DocenteService serDoce;
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		model.addAttribute("docentes", serDoce.listarTodos());
		return "docente";
	}
	
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("apellido") String ape,
			@RequestParam("dni") String dni,
			@RequestParam("estadoCiv") String estado,
			@RequestParam("genero") String gen,
			RedirectAttributes redirect)
	{
		
		try {
			
			Docente d =new Docente();
			d.setApellido(ape);
			d.setNombre(nom);
			d.setDni(dni);
			d.setEstadocivil(estado);
			
			d.setGenero(gen);
			
			if(cod==0) {
				serDoce.registrar(d);
			
			//Enviar atributo
			redirect.addFlashAttribute("MENSAJE","Docente registrado");
			}
			else {
				d.setCodigo(cod);
				serDoce.actualizar(d);
				redirect.addFlashAttribute("MENSAJE","Docente actualizado");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
			e.printStackTrace();
		}
		
		return "redirect:/docente/lista";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Docente buscarPorCodigo(@RequestParam("codigo")Integer cod) {
		return serDoce.buscarPorId(cod);
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigoEliminar")Integer cod,
									RedirectAttributes redirect) {
		serDoce.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE", "Docente " + cod + " eliminado");
		
		return "redirect:/docente/lista";
	}
		
	
}
