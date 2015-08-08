package com.tigers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.tigers.entities.Menu;
import com.tigers.service.GenericServiceImpl;

@ManagedBean(name="menubean")
@SessionScoped
public class MenuBean {

	private List<Menu> menus;
	private Menu menu;
	
	@PostConstruct
	public void init(){
		this.menus=new GenericServiceImpl<Menu>().listAll(Menu.class);
		System.out.println("fui instanciado");
	}
	
	public void onRowSelected(SelectEvent event){
		FacesMessage msg = new FacesMessage("Menu Selected",String.valueOf( ((Menu) event.getObject()).getIdmenu()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowUnselected(UnselectEvent event){
		FacesMessage msg = new FacesMessage("MenuUnselected",String.valueOf( ((Menu) event.getObject()).getIdmenu()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	
}
