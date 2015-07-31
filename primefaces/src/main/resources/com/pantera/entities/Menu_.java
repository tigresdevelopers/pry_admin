package com.pantera.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-26T17:49:13.943-0500")
@StaticMetamodel(Menu.class)
public class Menu_ {
	public static volatile SingularAttribute<Menu, Long> idmenu;
	public static volatile SingularAttribute<Menu, String> descripcion;
	public static volatile SingularAttribute<Menu, String> icono;
	public static volatile SingularAttribute<Menu, BigDecimal> idpadre;
	public static volatile SingularAttribute<Menu, String> url;
	public static volatile ListAttribute<Menu, Rol> rols;
}
