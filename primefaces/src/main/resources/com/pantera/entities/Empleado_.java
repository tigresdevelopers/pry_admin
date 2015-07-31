package com.pantera.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-31T00:42:38.867-0500")
@StaticMetamodel(Empleado.class)
public class Empleado_ {
	public static volatile SingularAttribute<Empleado, String> idempleado;
	public static volatile SingularAttribute<Empleado, String> activo;
	public static volatile SingularAttribute<Empleado, String> apeMa;
	public static volatile SingularAttribute<Empleado, String> apePa;
	public static volatile SingularAttribute<Empleado, String> celular;
	public static volatile SingularAttribute<Empleado, String> dni;
	public static volatile SingularAttribute<Empleado, String> email;
	public static volatile SingularAttribute<Empleado, Date> fecIngreso;
	public static volatile SingularAttribute<Empleado, Date> fecNacimiento;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile SingularAttribute<Empleado, String> sexo;
	public static volatile SingularAttribute<Empleado, String> telefono;
	public static volatile SingularAttribute<Empleado, Usuario> usuario;
	public static volatile ListAttribute<Empleado, PedidoCabe> pedidoCabes;
}
