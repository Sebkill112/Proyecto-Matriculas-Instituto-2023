package com.matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.matriculas.dao.MatriculaRepository;
import com.matriculas.entity.Matricula;

@Service
public class MatriculaService {

	
	@Autowired
	private MatriculaRepository repo;
	
	public String GenerarCodigo() {
		return repo.generarNumeroMatricula();
	}
	
	public void GrabarMatricula(Matricula i) {
		repo.save(i);
	}
}
