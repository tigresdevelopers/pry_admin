package com.tigers.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tigers.entities.Componente;
import com.tigers.entities.Rol;
import com.tigers.entities.TipoComponente;
import com.tigers.service.GenericService;
import com.tigers.service.GenericServiceImpl;

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
	
		for (TipoComponente o : lista) {
			System.out.println(o.getDescripcion());
		}
		
		
		
	}
	
}
