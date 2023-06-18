package com.matriculas.service;

import java.util.List;

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
	
	public List<Matricula> listadoMatriculasUsu(String dni,String estado){
		return repo.listarMatriculasUsuario(dni, estado);
	}
	public Matricula buscarPorID(String cod) {
		return repo.findById(cod).orElse(null);
	}
}
