package com.matriculas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario")
	public Integer codigo;
	@Column(name = "turno")
	public String turno;
	@Column(name = "vacantes")
	public int vacantes;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Docente docente;
	
}
