package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.CarreraRepository;
import com.matriculas.entity.Carrera;

@Service
public class CarreraService {

	@Autowired
	private CarreraRepository repo;

	public List<Carrera> listarCarreras() {
		return repo.findAll();
	}

	public Carrera BuscarCarreraPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}

}
