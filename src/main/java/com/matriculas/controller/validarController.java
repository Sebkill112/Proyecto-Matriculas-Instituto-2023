package com.matriculas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matriculas.entity.Alumno;
import com.matriculas.entity.Distrito;
import com.matriculas.entity.Docente;
import com.matriculas.entity.Enlace;
import com.matriculas.entity.Rol;
import com.matriculas.entity.Usuario;
import com.matriculas.service.AlumnoService;
import com.matriculas.service.DistritoService;
import com.matriculas.service.UsuarioServices;
@SessionAttributes({"datosUsuario","enlaces","dniUsuario"})
@Controller
@RequestMapping("/validar")
public class validarController {
	
	@Autowired
	private UsuarioServices servicio;
	
	@Autowired
	private AlumnoService serAlumno;
	
	@Autowired
	private DistritoService serDistrito;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/usuario")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping("/intranet")
	//Authentication interfaz
	public String intranet(Authentication auth,Model model) {
		String nomUsuario=auth.getName();
		Usuario bean=servicio.loginUsuario(nomUsuario);
		List<Enlace>lista=servicio.enlacesDelUsuario(bean.getRol().getCodigo());
		model.addAttribute("datosUsuario",bean.getNombre());
		model.addAttribute("dniUsuario",bean.getDni());
		model.addAttribute("enlaces",lista);
		
		
		
		return "intranet";
	}
	
	@RequestMapping("/registro")
	public String registro(Model model) {
		model.addAttribute("distrito",serDistrito.listarDistritos());
		
		return "registro";
	}
	
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("nombre") String nom,
			@RequestParam("correo") String correo,
			@RequestParam("apellido") String ape,
			@RequestParam("dni") String dni,
			@RequestParam("password") String clave,
			@RequestParam("fecha") String fec,
			@RequestParam("distrito") int dis,
			@RequestParam("direccion") String dic,
			RedirectAttributes redirect)
	{
		
		try {
			String pass =encoder.encode(clave);
			
			
			
			Usuario d =new Usuario();
			d.setNombre(nom);
			d.setCorreo(correo);
			d.setDni(dni);
			d.setPassword(pass);
			
			Rol r = new Rol();
			r.setCodigo(3);
			d.setRol(r);
			
			servicio.grabarUsuario(d);
			
			Alumno a = new Alumno();
			a.setDni(dni);
			a.setApellido(ape);
			a.setFecNac(LocalDate.parse(fec));
			a.setCorreo(correo);
			a.setNombre(nom);
			a.setDireccion(dic);
			Distrito u = new Distrito();
			u.setCodigo(dis);
			a.setDistrito(u);
			
			serAlumno.GrabarAlumno(a);
			//Enviar atributo
			
			redirect.addFlashAttribute("MENSAJE","Usuario registrado");

		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
			e.printStackTrace();
		}
		
		return "redirect:/validar/registro";
	}
	
}
