package com.pantera.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;


/**
 * The persistent class for the CATEGORIA database table.
 * 
 */
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="SQ_GENERATOR_CATEGORIA",strategy="sequence",parameters={@Parameter(name="sequence",value="sq_categoria")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR_CATEGORIA")
	private long idcategoria;

	private String descripcion;

	//bi-directional many-to-many association to Catalogo
	@ManyToMany(mappedBy="categorias")
	private List<Catalogo> catalogos;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;

	public Categoria() {
	}

	public long getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Catalogo> getCatalogos() {
		return this.catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCategoria(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setCategoria(null);

		return producto;
	}

}