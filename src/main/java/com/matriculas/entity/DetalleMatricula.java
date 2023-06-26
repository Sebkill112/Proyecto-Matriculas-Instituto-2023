package com.matriculas.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "detallematricula")
public class DetalleMatricula implements Serializable {

	@EmbeddedId
	private DetalleMatriculaPK pk;

	// Relación MUCHOS a UNO "Medicamento"
	@ManyToOne
	@JoinColumn(name = "id_matricula", referencedColumnName = "id_matricula", insertable = false, updatable = false)
	private Matricula matricula;// ASOCI.

	// Relación MUCHOS a UNO "Boleta"
	@ManyToOne
	@JoinColumn(name = "id_horario", referencedColumnName = "id_horario", insertable = false, updatable = false)
	private Horario horario;// ASOCI.

	public DetalleMatriculaPK getPk() {
		return pk;
	}

	public void setPk(DetalleMatriculaPK pk) {
		this.pk = pk;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	

}
