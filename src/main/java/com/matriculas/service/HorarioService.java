package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.HorarioRepository;
import com.matriculas.entity.Horario;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repo;
	
	public List<Horario> listarHorariosFiltro(String turno, int ciclo){
		return repo.listarMatriculasUsuario(turno, ciclo);
	}
}
