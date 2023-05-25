package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.FacultadRepository;
import com.matriculas.entity.Facultad;

@Service
public class FacultadService {

	@Autowired
	private FacultadRepository repo;
	
	public List<Facultad> listarFacultades(){
		return repo.findAll();
	}
	
	
}
