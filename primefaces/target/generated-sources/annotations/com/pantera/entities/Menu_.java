package com.pantera.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Menu.class)
public abstract class Menu_ {

	public static volatile SingularAttribute<Menu, Long> idmenu;
	public static volatile ListAttribute<Menu, Rol> rols;
	public static volatile SingularAttribute<Menu, String> icono;
	public static volatile SingularAttribute<Menu, BigDecimal> idpadre;
	public static volatile SingularAttribute<Menu, String> descripcion;
	public static volatile SingularAttribute<Menu, String> url;

}

