package com.tigers.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PEDIDO_DETA database table.
 * 
 */
@Embeddable
public class PedidoDetaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PEDIDO_CABE_PC_ID", insertable=false, updatable=false)
	private long pedidoCabePcId;

	@Column(name="PRODUCTO_IDPRODUCTO", insertable=false, updatable=false)
	private String productoIdproducto;

	
	public PedidoDetaPK() {
	}
	
	public long getPedidoCabePcId() {
		return this.pedidoCabePcId;
	}
	public void setPedidoCabePcId(long pedidoCabePcId) {
		this.pedidoCabePcId = pedidoCabePcId;
	}
	public String getProductoIdproducto() {
		return this.productoIdproducto;
	}
	public void setProductoIdproducto(String productoIdproducto) {
		this.productoIdproducto = productoIdproducto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PedidoDetaPK)) {
			return false;
		}
		PedidoDetaPK castOther = (PedidoDetaPK)other;
		return 
			(this.pedidoCabePcId == castOther.pedidoCabePcId)
			&& this.productoIdproducto.equals(castOther.productoIdproducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.pedidoCabePcId ^ (this.pedidoCabePcId >>> 32)));
		hash = hash * prime + this.productoIdproducto.hashCode();
		
		return hash;
	}
}