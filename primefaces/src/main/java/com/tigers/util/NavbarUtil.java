package com.tigers.util;

import java.util.List;

import com.tigers.entities.Menu;
/**
 * 
 * @author Pantera
 *
 */
public class NavbarUtil {

	
	
	
	/**
	 * Metodo para crear el menu de navegación segun el usuario
	 * logueado en el sistema
	 * @param menus     -> List<Menu>: lista de Menu
	 * @return navbar   -> String    : cadena con el menu
	 * @throws Exception 
	 */
	public static String getMenu(List<Menu> menus,String foto) throws Exception{
		
		final String PATH="properties/navbar";
		
		//Hacemos_una_copia_de_los_menus_para_iterar_y_buscar_los_menus_hijos
		List<Menu> children=menus;
		
		String navbar=FileUtil.loadBundle(PATH,"opentag");
		
		navbar=navbar.replace("{{USERNAME}}","Alexander Chavez");
		navbar=navbar.replace("{{FOTO}}",foto);
		
		for (Menu menu : menus) {
			
			if (menu.getIdpadre()==0 && menu.getUrl().equals("#")) {
				
				navbar+="<li><a href='"+menu.getUrl()+"' >"+menu.getIcono()+menu.getDescripcion()+"<span class=\"fa arrow\"></span></a>";
				navbar+="<ul class=\"nav nav-second-level\">";
				
					for (Menu child : children) {
						if (child.getIdpadre()==menu.getIdmenu()) {
							navbar+="<li><a href='"+child.getUrl()+"'>"+child.getIcono()+child.getDescripcion()+"</a></li>";
						}
					}
					navbar+="</ul></li>";
			}	
			
			
			if(menu.getIdpadre()==0 && !menu.getUrl().equals("#") ) {
				navbar+="<li><a href='"+menu.getUrl()+"' >"+menu.getIcono()+menu.getDescripcion()+"</a></li>";
			}
			
		}
		
		navbar+=FileUtil.loadBundle(PATH,"endtag");
		
		return navbar;
	} 
	
	
}
