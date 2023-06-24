package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.CursoRepository;
import com.matriculas.entity.Curso;

@Service
public class CursoService {
	@Autowired
    private CursoRepository repo;
    
    public List<Curso> listarCursos(){
   	 return repo.findAll();
    }
    
    public void agregar(Curso c) {
   	 repo.save(c);
    }
    public void actualizar(Curso c) {
   	 repo.save(c);
    }
    public void eliminarPorId(String cod) {
		repo.deleteById(cod);
	}

	public Curso BuscarCarreraPorID(String cod) {
		return repo.findById(cod).orElse(null);
	}
}
