package com.matriculas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matriculas.entity.Horario;
import com.matriculas.entity.Matricula;

public interface HorarioRepository extends JpaRepository<Horario, Integer>{
	
	@Query("select h from Horario h where h.turno=?1 and h.ciclo=?2")
	public List<Horario> listarMatriculasUsuario(String turno,int ciclo);

	
}
