package com.matriculas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;


import com.matriculas.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, String>{
	
	@Query(value = "{call sp_generar_numero()}" ,nativeQuery = true)
	public String generarNumeroMatricula();
	
	
	@Query("select m from Matricula m inner join Usuario u on m.alumno.dni = u.dni where u.dni=?1 and m.estado =?2")
	public List<Matricula> listarMatriculasUsuario(String dni,String estado);

}
