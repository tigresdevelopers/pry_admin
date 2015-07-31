package com.pantera.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.883-0500")
@StaticMetamodel(PedidoDeta.class)
public class PedidoDeta_ {
	public static volatile SingularAttribute<PedidoDeta, PedidoDetaPK> id;
	public static volatile SingularAttribute<PedidoDeta, BigDecimal> cantidad;
	public static volatile SingularAttribute<PedidoDeta, BigDecimal> precio;
	public static volatile SingularAttribute<PedidoDeta, BigDecimal> subtotal;
	public static volatile SingularAttribute<PedidoDeta, PedidoCabe> pedidoCabe;
	public static volatile SingularAttribute<PedidoDeta, Producto> producto;
}
