package com.matriculas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matriculas.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String>{
	boolean existsByDni(String dni);
	
	@Query("select a from Alumno a where a.nombre like %?1%")
	public List<Alumno> listaAlumoPorNombre(String nom);
}
