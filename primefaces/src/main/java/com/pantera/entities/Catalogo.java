package com.pantera.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;


/**
 * The persistent class for the CATALOGO database table.
 * 
 */
@Entity
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="SQ_GENERATOR_CATALOGO",strategy="sequence",parameters={@Parameter(name="sequence",value="sq_catalogo")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR_CATALOGO")
	private long idcatalogo;

	private String descripcion;

	private String vigente;

	//bi-directional many-to-many association to Categoria
	@ManyToMany
	@JoinTable(
		name="CATALOGO_CATEGORIA"
		, joinColumns={
			@JoinColumn(name="CATALOGO_IDCATALOGO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CATEGORIA_IDCATEGORIA")
			}
		)
	private List<Categoria> categorias;

	public Catalogo() {
	}

	public long getIdcatalogo() {
		return this.idcatalogo;
	}

	public void setIdcatalogo(long idcatalogo) {
		this.idcatalogo = idcatalogo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVigente() {
		return this.vigente;
	}

	public void setVigente(String vigente) {
		this.vigente = vigente;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}