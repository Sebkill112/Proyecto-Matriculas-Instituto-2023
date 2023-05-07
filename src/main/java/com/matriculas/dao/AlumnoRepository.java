package com.matriculas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matriculas.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String>{

}
