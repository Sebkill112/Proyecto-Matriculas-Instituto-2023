package com.matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.InscripcionRepository;

@Service
public class InscripcionService {

	
	@Autowired
	private InscripcionRepository repo;
	
	public String GenerarCodigo() {
		return repo.generarNumeroInscripcion();
	}
}
