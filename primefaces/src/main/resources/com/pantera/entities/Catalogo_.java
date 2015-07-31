package com.pantera.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.731-0500")
@StaticMetamodel(Catalogo.class)
public class Catalogo_ {
	public static volatile SingularAttribute<Catalogo, Long> idcatalogo;
	public static volatile SingularAttribute<Catalogo, String> descripcion;
	public static volatile SingularAttribute<Catalogo, String> vigente;
	public static volatile ListAttribute<Catalogo, Categoria> categorias;
}
