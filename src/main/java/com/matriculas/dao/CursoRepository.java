package com.matriculas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matriculas.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, String>{

}
