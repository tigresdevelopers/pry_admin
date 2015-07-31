package com.pantera.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-26T17:49:13.947-0500")
@StaticMetamodel(Rol.class)
public class Rol_ {
	public static volatile SingularAttribute<Rol, Long> idrol;
	public static volatile SingularAttribute<Rol, String> descripcion;
	public static volatile ListAttribute<Rol, Menu> menus;
	public static volatile ListAttribute<Rol, Usuario> usuarios;
}
