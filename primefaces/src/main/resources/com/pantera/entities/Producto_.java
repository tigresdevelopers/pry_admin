package com.pantera.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.894-0500")
@StaticMetamodel(Producto.class)
public class Producto_ {
	public static volatile SingularAttribute<Producto, String> idproducto;
	public static volatile SingularAttribute<Producto, String> activo;
	public static volatile SingularAttribute<Producto, String> codigobarra;
	public static volatile SingularAttribute<Producto, String> descripcion;
	public static volatile SingularAttribute<Producto, BigDecimal> descuento;
	public static volatile SingularAttribute<Producto, String> imagen1;
	public static volatile SingularAttribute<Producto, String> imagen2;
	public static volatile SingularAttribute<Producto, String> imagen3;
	public static volatile SingularAttribute<Producto, BigDecimal> precio;
	public static volatile SingularAttribute<Producto, BigDecimal> stock;
	public static volatile SingularAttribute<Producto, BigDecimal> stockminimo;
	public static volatile ListAttribute<Producto, PedidoDeta> pedidoDetas;
	public static volatile SingularAttribute<Producto, Categoria> categoria;
	public static volatile ListAttribute<Producto, Cliente> clientes;
}
