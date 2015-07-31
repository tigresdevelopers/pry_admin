package com.pantera.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.859-0500")
@StaticMetamodel(Componente.class)
public class Componente_ {
	public static volatile SingularAttribute<Componente, Long> idcomponente;
	public static volatile SingularAttribute<Componente, String> contenido;
	public static volatile SingularAttribute<Componente, BigDecimal> idpadre;
	public static volatile SingularAttribute<Componente, String> imagen;
	public static volatile SingularAttribute<Componente, TipoComponente> tipoComponente;
}
