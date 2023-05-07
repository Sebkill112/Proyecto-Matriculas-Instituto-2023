package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.DistritoRepository;
import com.matriculas.entity.Distrito;

@Service
public class DistritoService {

	@Autowired
	private DistritoRepository repo;
	
	
	public List<Distrito> listarDistritos(){
		return repo.findAll();
	}
}
