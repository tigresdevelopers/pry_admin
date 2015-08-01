package com.pantera.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.pantera.util.FileUtil;

@ManagedBean
@SessionScoped
public class Test {

	private String nombre;
	
	public void bienvenido(){
		System.out.println("invocado");
	    RequestContext.getCurrentInstance().execute("alert('Bienvenido: "+this.nombre+"');");
	}

	public void  mantenimientos() throws Exception{
	    FacesContext.getCurrentInstance().getExternalContext().redirect(FileUtil.loadBundleLink("mantenimiento"));
	}
	
	public void  login() throws Exception{
	    FacesContext.getCurrentInstance().getExternalContext().redirect(FileUtil.loadBundleLink("login"));
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
