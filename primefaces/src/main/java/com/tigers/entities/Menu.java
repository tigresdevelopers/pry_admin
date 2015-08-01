package com.tigers.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="SQ_GENERATOR_MENU",strategy="sequence",parameters={@Parameter(name="sequence",value="sq_menu")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR_MENU")
	private long idmenu;

	private String descripcion;

	private String icono;

	private BigDecimal idpadre;

	private String url;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="MENU_ROL"
		, joinColumns={
			@JoinColumn(name="MENU_IDMENU")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROL_IDROL")
			}
		)
	private List<Rol> rols;

	public Menu() {
	}

	public long getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(long idmenu) {
		this.idmenu = idmenu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public BigDecimal getIdpadre() {
		return this.idpadre;
	}

	public void setIdpadre(BigDecimal idpadre) {
		this.idpadre = idpadre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}