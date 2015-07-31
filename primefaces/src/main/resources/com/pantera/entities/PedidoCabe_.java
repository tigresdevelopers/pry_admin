package com.pantera.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.878-0500")
@StaticMetamodel(PedidoCabe.class)
public class PedidoCabe_ {
	public static volatile SingularAttribute<PedidoCabe, Long> pcId;
	public static volatile SingularAttribute<PedidoCabe, BigDecimal> descuento;
	public static volatile SingularAttribute<PedidoCabe, Date> fecEntrega;
	public static volatile SingularAttribute<PedidoCabe, Date> fecPedido;
	public static volatile SingularAttribute<PedidoCabe, String> idpedido;
	public static volatile SingularAttribute<PedidoCabe, BigDecimal> total;
	public static volatile SingularAttribute<PedidoCabe, Cliente> cliente;
	public static volatile SingularAttribute<PedidoCabe, Empleado> empleado;
	public static volatile ListAttribute<PedidoCabe, PedidoDeta> pedidoDetas;
}
