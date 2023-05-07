package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.PaisRepository;
import com.matriculas.entity.Pais;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repo;
	
	
	public List<Pais> ListarPaises() {
		return repo.findAll();
	}
}
