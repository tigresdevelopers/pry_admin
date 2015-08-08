package com.tigers.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tigers.entities.Menu;
import com.tigers.service.GenericService;
import com.tigers.service.GenericServiceImpl;
import com.tigers.util.NavbarUtil;

public class HibernateTest {

	public static void main(String[] args) throws Exception {
		
		GenericService<Menu> dao=new GenericServiceImpl<Menu>();
		
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("id",3);
		
		List<Menu> lista = null;
		try {
			//lista = dao.listHQL("select idmenu as idmenu,descripcion as descripcion from "+(Menu.class).getSimpleName()+" where idpadre= :id",parameters,Menu.class);
			lista=dao.listAll(Menu.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println(NavbarUtil.getMenu(lista,""));
		
	}
	
	

	
	
}
