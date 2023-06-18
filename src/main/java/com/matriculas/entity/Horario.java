package com.matriculas.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@Column(name = "ciclo")
	public int ciclo;

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_docente")
	private Docente docente;
	
	// Relación UNO a MUCHOS
		@OneToMany(mappedBy = "horario")
		@JsonIgnore
		private List<DetalleMatricula> listaDetalle;


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
