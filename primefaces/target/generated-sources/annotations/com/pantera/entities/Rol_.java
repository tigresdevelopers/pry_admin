package com.pantera.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rol.class)
public abstract class Rol_ {

	public static volatile ListAttribute<Rol, Menu> menus;
	public static volatile SingularAttribute<Rol, Long> idrol;
	public static volatile SingularAttribute<Rol, String> descripcion;
	public static volatile ListAttribute<Rol, Usuario> usuarios;

}

