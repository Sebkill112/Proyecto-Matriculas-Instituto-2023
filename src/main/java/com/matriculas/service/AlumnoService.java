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
	
    public void GrabarAlumno(Alumno a) {
    	repo.save(a);
    }
    
    public List<Alumno> ListarAlumnos(){
    	return repo.findAll();
    }
}
