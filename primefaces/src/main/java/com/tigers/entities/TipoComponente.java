package com.tigers.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the TIPO_COMPONENTE database table.
 * 
 */
@Entity
@Table(name="TIPO_COMPONENTE")
public class TipoComponente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="SQ_GENERATOR_TCOMPONENTE",strategy="sequence",parameters={@Parameter(name="sequence",value="sq_tcomponente")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR_TCOMPONENTE")
	private int idtipo;

	private String descripcion;

	//bi-directional many-to-one association to Componente
	@OneToMany(mappedBy="tipoComponente")
	private List<Componente> componentes;

	public TipoComponente() {
	}

	public long getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Componente> getComponentes() {
		return this.componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public Componente addComponente(Componente componente) {
		getComponentes().add(componente);
		componente.setTipoComponente(this);

		return componente;
	}

	public Componente removeComponente(Componente componente) {
		getComponentes().remove(componente);
		componente.setTipoComponente(null);

		return componente;
	}

}