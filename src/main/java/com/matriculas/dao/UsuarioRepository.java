package com.matriculas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matriculas.entity.Enlace;
import com.matriculas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.correo=?1")
	public Usuario iniciarSesion(String vCorreo);
	
	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace>traerEnlacesDelUsuario(int codigoRol);

}
