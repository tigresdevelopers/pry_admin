package com.pantera.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCTO database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idproducto;

	private String activo;

	private String codigobarra;

	private String descripcion;

	private BigDecimal descuento;

	private String imagen1;

	private String imagen2;

	private String imagen3;

	private BigDecimal precio;

	private BigDecimal stock;

	private BigDecimal stockminimo;

	//bi-directional many-to-one association to PedidoDeta
	@OneToMany(mappedBy="producto")
	private List<PedidoDeta> pedidoDetas;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	//bi-directional many-to-many association to Cliente
	@ManyToMany
	@JoinTable(
		name="PRODUCTO_DESEADO"
		, joinColumns={
			@JoinColumn(name="PRODUCTO_IDPRODUCTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CLIENTE_IDCLIENTE")
			}
		)
	private List<Cliente> clientes;

	public Producto() {
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCodigobarra() {
		return this.codigobarra;
	}

	public void setCodigobarra(String codigobarra) {
		this.codigobarra = codigobarra;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public String getImagen1() {
		return this.imagen1;
	}

	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}

	public String getImagen2() {
		return this.imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getImagen3() {
		return this.imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getStock() {
		return this.stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public BigDecimal getStockminimo() {
		return this.stockminimo;
	}

	public void setStockminimo(BigDecimal stockminimo) {
		this.stockminimo = stockminimo;
	}

	public List<PedidoDeta> getPedidoDetas() {
		return this.pedidoDetas;
	}

	public void setPedidoDetas(List<PedidoDeta> pedidoDetas) {
		this.pedidoDetas = pedidoDetas;
	}

	public PedidoDeta addPedidoDeta(PedidoDeta pedidoDeta) {
		getPedidoDetas().add(pedidoDeta);
		pedidoDeta.setProducto(this);

		return pedidoDeta;
	}

	public PedidoDeta removePedidoDeta(PedidoDeta pedidoDeta) {
		getPedidoDetas().remove(pedidoDeta);
		pedidoDeta.setProducto(null);

		return pedidoDeta;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}