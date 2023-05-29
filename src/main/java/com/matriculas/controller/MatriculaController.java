package com.matriculas.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matriculas.entity.Alumno;
import com.matriculas.entity.Carrera;
import com.matriculas.entity.Matricula;
import com.matriculas.service.AlumnoService;
import com.matriculas.service.CarreraService;
import com.matriculas.service.MatriculaService;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

	@Autowired
	private AlumnoService serAlumno;

	@Autowired
	private MatriculaService servicio;

	@Autowired
	private CarreraService serCarrera;

	@RequestMapping("/registro")
	public String registro(Model model) {
		model.addAttribute("codigo", servicio.GenerarCodigo());
		model.addAttribute("fecha", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		model.addAttribute("carreras",serCarrera.listarCarreras());
		return "matricula";
	}

	@RequestMapping("/alumno")
	@ResponseBody
	public List<Alumno> listarAlumnos() {
		return serAlumno.ListarAlumnos();
	}
	
	@RequestMapping("/grabar")
	public String GrabarInscripcion(@RequestParam("numero") String cod,@RequestParam("carrera") int carrera,@RequestParam("fecha")
	String fec,@RequestParam("dni") String dni,@RequestParam("ciclo") String ciclo,RedirectAttributes redirect) {
		
		try {
			Matricula ins = new Matricula();
			ins.setIdMatricula(cod);
			Carrera c = new Carrera();
			c.setCodigo(carrera);
			ins.setCarrera(c);
			Alumno a = new Alumno();
			a.setDni(dni);
			ins.setAlumno(a);
			ins.setFecha(LocalDate.parse(fec));
			ins.setEstado("PENDIENTE DE PAGO");
			ins.setCiclo(ciclo);
			
			servicio.GrabarMatricula(ins);
			
			redirect.addFlashAttribute("MENSAJE","Matricula Grabada");
		
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
			e.printStackTrace();
		}
		
		
		
		return "redirect:/matricula/registro";
	}
	
	@RequestMapping("/listar")
	@ResponseBody
	public List<Matricula> listadoMatricula(@RequestParam("dni") String dni,String estado){
		return servicio.listadoMatriculasUsu(dni, estado);
	}

	
}
