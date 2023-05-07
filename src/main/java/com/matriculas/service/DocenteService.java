package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.matriculas.dao.DocenteRepository;
import com.matriculas.entity.Docente;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository repo;
	
	
	public void registrar(Docente d) {
		repo.save(d);
	}
	
	public void actualizar(Docente d) {
		repo.save(d);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Docente>listarTodos(){
		return repo.findAll();
	}
	public Docente buscarPorId(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	
}
