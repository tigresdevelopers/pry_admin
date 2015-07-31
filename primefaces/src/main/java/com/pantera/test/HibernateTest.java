package com.pantera.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pantera.entities.Componente;
import com.pantera.entities.Rol;
import com.pantera.entities.TipoComponente;
import com.pantera.service.GenericService;
import com.pantera.service.GenericServiceImpl;

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
		
		GenericService<TipoComponente> dao=new GenericServiceImpl<TipoComponente>();
		//dao.saveOrUpdate(c);
		
		/* */
		
		
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("id",1);
		
		List<TipoComponente> lista = null;
		try {
			lista = dao.listHQL("select idtipo as idtipo,descripcion as descripcion from "+(TipoComponente.class).getSimpleName()+" where idtipo= :id",parameters,TipoComponente.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		for (Componente o : new GenericServiceImpl<Componente>().listAll(Componente.class)) {
			System.out.println(o.getContenido());
		}
		
		
		
	}
	
}
