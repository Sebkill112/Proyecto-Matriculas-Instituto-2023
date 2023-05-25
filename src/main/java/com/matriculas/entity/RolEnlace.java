package com.matriculas.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "acceso")
public class RolEnlace {

	@EmbeddedId
	private RolEnlacePK id;

	@ManyToOne
	@JoinColumn(name = "idrol", insertable = false, updatable = false, referencedColumnName = "idrol")
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "idenlace", insertable = false, updatable = false, referencedColumnName = "idenlace")
	private Enlace enlace;

	public RolEnlacePK getId() {
		return id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}

}
