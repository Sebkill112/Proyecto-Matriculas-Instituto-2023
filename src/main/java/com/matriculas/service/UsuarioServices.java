package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.UsuarioRepository;
import com.matriculas.entity.Enlace;
import com.matriculas.entity.Usuario;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repo;
	
	
	public Usuario loginUsuario(String vCorreo) {
		return repo.iniciarSesion(vCorreo);
	}
	
	public List<Enlace> enlacesDelUsuario(int rol){
		return repo.traerEnlacesDelUsuario(rol);
	}
}
