package com.matriculas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matriculas.entity.Carrera;


public interface CarreraRepository extends JpaRepository<Carrera, Integer>{
	
	@Query("select c from Carrera c where c.facultad.codigo=?1")
	public List<Carrera> findAllByFacultad(Integer codCarr);

}
