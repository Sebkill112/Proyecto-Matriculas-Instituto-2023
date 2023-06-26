package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matriculas.dao.AlumnoRepository;
import com.matriculas.entity.Alumno;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository repo;
	
    public void registrarAlumno(Alumno a) {
    	repo.save(a);
    }
    public void actualizarAlumno(Alumno a) {
    	repo.save(a);
    }
    
    public List<Alumno> ListarAlumnos(){
    	return repo.findAll();
    }
    
    public void EliminarAlumno(String cod) {
    	repo.deleteById(cod);
    }
    
    public Alumno BuscarAlumnoPorCodigo(String dni) {
    	return repo.findById(dni).orElse(null);
    }
    
    public boolean exiteDni(String dni)
    {
    	return repo.existsByDni(dni);
    }
    public List<Alumno> listarPorNombre(String nom)
    {
    	return repo.listaAlumoPorNombre(nom);
    }
    
    
}
