package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.HorarioRepository;
import com.matriculas.entity.Carrera;
import com.matriculas.entity.Curso;
import com.matriculas.entity.Horario;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repo;
	
	public List<Horario> listarHorariosFiltro(String turno, int ciclo){
		return repo.listarMatriculasUsuario(turno, ciclo);
	}
	
	public List<Horario> listarTodos() {
		
		return repo.findAll();
		
	}
	
	public void registrar(Horario h) {
		
		repo.save(h);
		
	}
	
	 public void actualizar(Horario h) {
	   	 repo.save(h);
	 }
	 
	 public void eliminarPorId(int cod) {
				 
		 repo.deleteById(cod);
		 
	}
	 
	 public Horario BuscarHorarioPorID(Integer cod) {
			return repo.findById(cod).orElse(null);
		}
	
}
