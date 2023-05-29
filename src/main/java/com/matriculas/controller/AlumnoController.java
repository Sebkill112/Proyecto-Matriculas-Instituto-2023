package com.matriculas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matriculas.entity.Alumno;
import com.matriculas.entity.Distrito;
import com.matriculas.service.AlumnoService;
import com.matriculas.service.DistritoService;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService serAlu;
	
	@Autowired
	private DistritoService serDist;
	
	
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("alumnos", serAlu.ListarAlumnos());
		model.addAttribute("distritos", serDist.listarDistritos());		
		return "alumno";
	}
	
	public int indice(String dni) {
		List<Alumno> lista = serAlu.ListarAlumnos();
		int resu = 0;
		String d = dni;
		for(int i=0;i<lista.size();i++) {		
			if(lista.get(i).getDni().equals(dni)) {
				resu = i;
			}
		}
		return resu;
	}
	
	@RequestMapping("/guardar")
	public String guardar(@RequestParam("dni") String dni,
	                      @RequestParam("nombre") String nombre,
	                      @RequestParam("apellido") String apellido,
	                      @RequestParam("fecha") String fecha,
	                      @RequestParam("correo") String correo,
	                      @RequestParam("distrito") int codDis, // Corrección: distrito en lugar de distrtio
	                      @RequestParam("direccion") String direccion,
	                      RedirectAttributes redirect) {
		try {
			Alumno alu = new Alumno();
			alu.setDni(dni);
			alu.setNombre(nombre);
			alu.setApellido(apellido);
			alu.setFecNac(LocalDate.parse(fecha));
			alu.setCorreo(correo);
			alu.setDireccion(direccion);
			Distrito dis = new Distrito();
			dis.setCodigo(codDis);
			alu.setDistrito(dis);
			
			int post = indice(dni);
			
			if (post==0) {
				serAlu.registrarAlumno(alu);
				redirect.addFlashAttribute("MENSAJE", "Alumno Registrado");
					
			} else {
				serAlu.actualizarAlumno(alu);
				redirect.addFlashAttribute("MENSAJE", "Alumno Actualizado");
			}	
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al registra");
			e.printStackTrace();
		}
	    
	    return "redirect:/alumno/lista";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Alumno BuscarPorId(@RequestParam("dni") String dni) {
		return serAlu.BuscarAlumnoPorCodigo(dni);
	}
	@RequestMapping("/eliminar")
	public String eliminarPorDni(@RequestParam("dniDelete") String dni,
									RedirectAttributes redirect)
	{
		serAlu.EliminarAlumno(dni);
		redirect.addFlashAttribute("MENSAJE", "Alumno Eliminado");			
		return "redirect:/alumno/lista";	
	}
	

	
}
