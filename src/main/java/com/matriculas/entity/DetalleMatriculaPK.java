package com.matriculas.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class DetalleMatriculaPK implements Serializable {

	@Column(name = "id_matricula")
	private String codigoMatricula;
	@Column(name = "id_horario")
	private int codigoHorario;

	public String getCodigoMatricula() {
		return codigoMatricula;
	}

	public void setCodigoMatricula(String codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

	public int getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoHorario, codigoMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleMatriculaPK other = (DetalleMatriculaPK) obj;
		if (codigoHorario != other.codigoHorario)
			return false;
		if (codigoMatricula != other.codigoMatricula)
			return false;
		return true;
	}

}
