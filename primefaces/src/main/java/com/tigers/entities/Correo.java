package com.tigers.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CORREO database table.
 * 
 */
@Entity
public class Correo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idcorreo;

	private String descripcion;

	private String plantilla;

	public Correo() {
	}

	public long getIdcorreo() {
		return this.idcorreo;
	}

	public void setIdcorreo(long idcorreo) {
		this.idcorreo = idcorreo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPlantilla() {
		return this.plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

}