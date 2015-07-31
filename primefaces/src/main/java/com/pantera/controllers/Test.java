package com.pantera.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class Test {

	private String nombre;
	
	public void bienvenido(){
		System.out.println("invocado");
	  RequestContext.getCurrentInstance().execute("alert('Bienvenido: "+this.nombre+"');");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
