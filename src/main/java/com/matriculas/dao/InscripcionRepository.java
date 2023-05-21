package com.matriculas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.matriculas.entity.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, String>{
	
	@Query(value = "{call sp_generar_numero()}" ,nativeQuery = true)
	public String generarNumeroInscripcion();

}
