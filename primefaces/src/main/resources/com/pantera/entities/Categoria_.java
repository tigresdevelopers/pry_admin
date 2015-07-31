package com.pantera.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.848-0500")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, Long> idcategoria;
	public static volatile SingularAttribute<Categoria, String> descripcion;
	public static volatile ListAttribute<Categoria, Catalogo> catalogos;
	public static volatile ListAttribute<Categoria, Producto> productos;
}
