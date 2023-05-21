package com.matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.InscripcionRepository;
import com.matriculas.entity.Inscripcion;

@Service
public class InscripcionService {

	
	@Autowired
	private InscripcionRepository repo;
	
	public String GenerarCodigo() {
		return repo.generarNumeroInscripcion();
	}
	
	public void GrabarInscripcion(Inscripcion i) {
		repo.save(i);
	}
}
