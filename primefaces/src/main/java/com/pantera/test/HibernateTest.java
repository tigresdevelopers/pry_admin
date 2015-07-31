package com.pantera.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pantera.dao.GenericDaoImpl;
import com.pantera.entities.Componente;
import com.pantera.entities.Rol;
import com.pantera.entities.TipoComponente;

public class HibernateTest {

	
	
	public static void main(String[] args) {
		Rol obj=new Rol();
		obj.setIdrol(3);
		obj.setDescripcion("HqlGeneric");
		
		TipoComponente tc=new TipoComponente();
		tc.setIdtipo(1);
		tc.setDescripcion("carousel");
		
		Componente c=new Componente();
		c.setIdcomponente(2);
		c.setContenido("contenido2");
		c.setImagen("");
		c.setIdpadre(0);
		c.setTipoComponente(tc);
		
		GenericDaoImpl<Componente> dao=new GenericDaoImpl<Componente>();
		//dao.saveOrUpdate(c);
		
		/* */
		List<Componente> lista=dao.listAll(Componente.class);
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("id",(long)1);
		//lista=dao.listHQL("from Rol where idrol=:id",parameters,Rol.class);
		for (Object rol : lista) {
			if(rol instanceof Componente)
				System.out.println(((Componente)rol).getContenido());
		}
		
		
		
	}
	
}
