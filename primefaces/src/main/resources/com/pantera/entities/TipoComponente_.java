package com.pantera.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.922-0500")
@StaticMetamodel(TipoComponente.class)
public class TipoComponente_ {
	public static volatile SingularAttribute<TipoComponente, Long> idtipo;
	public static volatile SingularAttribute<TipoComponente, String> descripcion;
	public static volatile ListAttribute<TipoComponente, Componente> componentes;
}
