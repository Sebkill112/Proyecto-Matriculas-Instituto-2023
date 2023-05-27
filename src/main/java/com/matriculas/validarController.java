package com.matriculas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.matriculas.entity.Enlace;
import com.matriculas.entity.Usuario;
import com.matriculas.service.UsuarioServices;
@SessionAttributes({"datosUsuario","enlaces"})
@Controller
@RequestMapping("/validar")
public class validarController {
	
	@Autowired
	private UsuarioServices servicio;

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
		model.addAttribute("enlaces",lista);
		
		
		
		return "intranet";
	}
}
