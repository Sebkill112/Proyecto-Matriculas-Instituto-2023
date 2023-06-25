package com.matriculas.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.matriculas.entity.Curso;
import com.matriculas.entity.Detalle;
import com.matriculas.entity.DetalleMatricula;
import com.matriculas.entity.Docente;
import com.matriculas.entity.Horario;
import com.matriculas.entity.Matricula;
import com.matriculas.service.HorarioService;
import com.matriculas.service.MatriculaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private HorarioService serHorario;
	
	@Autowired
	private MatriculaService serMatricula;
	
	@RequestMapping("/registro")
	public String index() {
		return "DetalleMatricula";
	}
	
	@RequestMapping("/listar")
	@ResponseBody
	public List<Horario> listadoHorario(@RequestParam("turno")String turno,@RequestParam("ciclo") int ciclo){
		return serHorario.listarHorariosFiltro(turno, ciclo);
	}
	
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,@RequestParam("curso") String curso,
			@RequestParam("docente") String docente,@RequestParam("horario") String horario,HttpSession session) {
		//declarar un arreglo de objetos de la clase Detalle
		List<Detalle> lista=null;
		try {
			//validar si existe el atributo de tipo sesión "data"		
			if(session.getAttribute("data")==null)//no existe
				//crear el arrego lista
				lista=new ArrayList<Detalle>();
			else//si existe 
				//recuperar el atributo "data" y guardarlo en lista
				lista=(List<Detalle>) session.getAttribute("data");
				
			//crear objeto de la clase Detalle y guardar los valores de los parámetros
			Detalle det = new Detalle();
			det.setCodigo(cod);
			det.setCurso(curso);
			det.setDocente(docente);
			det.setHorario(horario);
			
			for (Detalle de : lista) {
				if (de.getCodigo() == cod) {

					return lista;

				}
			}
			
			//adicionar objeto "det" dentro del arreglo "lista"
			lista.add(det);
			//crear atributo "data"
			session.setAttribute("data", lista);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@RequestMapping("/eliminarHorario")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("cod") int cod, HttpSession session) {

		List<Detalle> lista = (List<Detalle>) session.getAttribute("data");

		for (Detalle d : lista) {
			if (d.getCodigo() == cod) {
				lista.remove(d);
				break;
			}
		}

		return lista;
	}
	
	@RequestMapping("/guardar")
	public String grabar(@RequestParam("matriculaID") String cod ,HttpSession session,RedirectAttributes redirect) {
		try {
			// crear objeto de la Entidad Boleta
			Matricula bol = new Matricula();
			bol.setIdMatricula(cod);
			// crear un arreglo de objetos de la entidad MedicamentoHasBoleta
			List<DetalleMatricula> lista = new ArrayList<DetalleMatricula>();
			// recuparar el atributo de tipo sesión "data"
			List<Detalle> datos = (List<Detalle>) session.getAttribute("data");
			// bucle para realizar recorrido sobre "datos"
			for (Detalle det : datos) {
				// crear objeto de la entidad MedicamentoHasBoleta
				DetalleMatricula mhb = new DetalleMatricula();
				// crear objeto de la entidad Medicamento
				Horario m = new Horario();
				// setear m
				m.setCodigo(det.getCodigo());
				// enviar objeto "m" al objeto "mhb"
				mhb.setHorario(m);
				// enviar el objeto "mhb" al arreglo "lista"
				lista.add(mhb);
			}
			// enviar el arreglo "lista" al atributo listaMedicamentoHasBoleta
			bol.setListaDetalleMatricula(lista);
			serMatricula.registrarHorariosMatricula(bol);
			
			datos.clear();
			session.setAttribute("data", datos);
			redirect.addFlashAttribute("MENSAJE","Horario registrado");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","error");
		}
		return "redirect:/horario/registro";
	}


	
	
}
