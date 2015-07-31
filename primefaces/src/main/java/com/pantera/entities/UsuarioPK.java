package com.pantera.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String idusuario;

	@Column(name="ROL_IDROL", insertable=false, updatable=false)
	private long rolIdrol;

	public UsuarioPK() {
	}
	public String getIdusuario() {
		return this.idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public long getRolIdrol() {
		return this.rolIdrol;
	}
	public void setRolIdrol(long rolIdrol) {
		this.rolIdrol = rolIdrol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			this.idusuario.equals(castOther.idusuario)
			&& (this.rolIdrol == castOther.rolIdrol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusuario.hashCode();
		hash = hash * prime + ((int) (this.rolIdrol ^ (this.rolIdrol >>> 32)));
		
		return hash;
	}
}