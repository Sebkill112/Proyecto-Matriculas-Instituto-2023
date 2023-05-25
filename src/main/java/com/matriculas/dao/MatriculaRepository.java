package com.matriculas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;


import com.matriculas.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, String>{
	
	@Query(value = "{call sp_generar_numero()}" ,nativeQuery = true)
	public String generarNumeroMatricula();

}
