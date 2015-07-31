package com.pantera.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the COMPONENTES database table.
 * 
 */
@Entity
@Table(name="COMPONENTES")
public class Componente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="SQ_GENERATOR_COMPONENTE",strategy="sequence",parameters={@Parameter(name="sequence",value="sq_componente")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR_COMPONENTE")
	private int idcomponente;

	private String contenido;

	private int idpadre;

	private String imagen;

	//bi-directional many-to-one association to TipoComponente
	@ManyToOne
	@JoinColumn(name="TIPO_COMPONENTE_IDTIPO")
	private TipoComponente tipoComponente;

	public Componente() {
	}

	public long getIdcomponente() {
		return this.idcomponente;
	}

	public void setIdcomponente(int idcomponente) {
		this.idcomponente = idcomponente;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getIdpadre() {
		return this.idpadre;
	}

	public void setIdpadre(int idpadre) {
		this.idpadre = idpadre;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public TipoComponente getTipoComponente() {
		return this.tipoComponente;
	}

	public void setTipoComponente(TipoComponente tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

}