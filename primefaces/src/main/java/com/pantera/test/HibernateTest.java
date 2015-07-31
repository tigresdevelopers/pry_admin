package com.pantera.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pantera.dao.GenericDaoImpl;
import com.pantera.entities.Rol;

public class HibernateTest {

	
	
	public static void main(String[] args) {
		Rol obj=new Rol();
		obj.setIdrol(3);
		obj.setDescripcion("HqlGeneric");
		
		GenericDaoImpl<Rol> dao=new GenericDaoImpl<Rol>();
		//dao.persist(obj);
		
		List<Rol> lista=dao.listAll(Rol.class);
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("id",(long)1);
		//lista=dao.listHQL("from Rol where idrol=:id",parameters,Rol.class);
		for (Object rol : lista) {
			if(rol instanceof Rol)
				System.out.println(((Rol)rol).getDescripcion());
		}
		
		
		
	}
	
}
