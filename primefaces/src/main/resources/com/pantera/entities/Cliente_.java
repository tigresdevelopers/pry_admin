package com.pantera.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.853-0500")
@StaticMetamodel(Cliente.class)
public class Cliente_ {
	public static volatile SingularAttribute<Cliente, String> idcliente;
	public static volatile SingularAttribute<Cliente, String> activo;
	public static volatile SingularAttribute<Cliente, String> apeMa;
	public static volatile SingularAttribute<Cliente, String> apePa;
	public static volatile SingularAttribute<Cliente, String> celular;
	public static volatile SingularAttribute<Cliente, String> dni;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, Date> fecNacimiento;
	public static volatile SingularAttribute<Cliente, Date> fecRegistro;
	public static volatile SingularAttribute<Cliente, String> nombre;
	public static volatile SingularAttribute<Cliente, String> sexo;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile SingularAttribute<Cliente, Usuario> usuario;
	public static volatile ListAttribute<Cliente, PedidoCabe> pedidoCabes;
	public static volatile ListAttribute<Cliente, Producto> productos;
}
