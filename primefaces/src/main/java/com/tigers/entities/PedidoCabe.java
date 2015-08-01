package com.tigers.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PEDIDO_CABE database table.
 * 
 */
@Entity
@Table(name="PEDIDO_CABE")
public class PedidoCabe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PC_ID")
	private long pcId;

	private BigDecimal descuento;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_ENTREGA")
	private Date fecEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_PEDIDO")
	private Date fecPedido;

	private String idpedido;

	private BigDecimal total;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	private Empleado empleado;

	//bi-directional many-to-one association to PedidoDeta
	@OneToMany(mappedBy="pedidoCabe")
	private List<PedidoDeta> pedidoDetas;

	public PedidoCabe() {
	}

	public long getPcId() {
		return this.pcId;
	}

	public void setPcId(long pcId) {
		this.pcId = pcId;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Date getFecEntrega() {
		return this.fecEntrega;
	}

	public void setFecEntrega(Date fecEntrega) {
		this.fecEntrega = fecEntrega;
	}

	public Date getFecPedido() {
		return this.fecPedido;
	}

	public void setFecPedido(Date fecPedido) {
		this.fecPedido = fecPedido;
	}

	public String getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<PedidoDeta> getPedidoDetas() {
		return this.pedidoDetas;
	}

	public void setPedidoDetas(List<PedidoDeta> pedidoDetas) {
		this.pedidoDetas = pedidoDetas;
	}

	public PedidoDeta addPedidoDeta(PedidoDeta pedidoDeta) {
		getPedidoDetas().add(pedidoDeta);
		pedidoDeta.setPedidoCabe(this);

		return pedidoDeta;
	}

	public PedidoDeta removePedidoDeta(PedidoDeta pedidoDeta) {
		getPedidoDetas().remove(pedidoDeta);
		pedidoDeta.setPedidoCabe(null);

		return pedidoDeta;
	}

}