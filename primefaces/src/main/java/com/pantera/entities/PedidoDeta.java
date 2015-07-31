package com.pantera.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PEDIDO_DETA database table.
 * 
 */
@Entity
@Table(name="PEDIDO_DETA")
public class PedidoDeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoDetaPK id;

	private BigDecimal cantidad;

	private BigDecimal precio;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to PedidoCabe
	@ManyToOne
	@JoinColumn(name="PEDIDO_CABE_PC_ID",insertable=false, updatable=false)
	private PedidoCabe pedidoCabe;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;	
	
	public PedidoDeta() {
	}

	
	public PedidoDetaPK getId() {
		return this.id;
	}

	public void setId(PedidoDetaPK id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public PedidoCabe getPedidoCabe() {
		return this.pedidoCabe;
	}

	public void setPedidoCabe(PedidoCabe pedidoCabe) {
		this.pedidoCabe = pedidoCabe;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}