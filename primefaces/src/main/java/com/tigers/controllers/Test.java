package com.tigers.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.tigers.entities.Componente;
import com.tigers.entities.TipoComponente;
import com.tigers.service.GenericService;
import com.tigers.service.GenericServiceImpl;
import com.tigers.util.FileUtil;
import com.tigers.util.jsf.Faces;

@ManagedBean
@SessionScoped
public class Test {

	private String nombre;
	
	//@Inject
	private GenericServiceImpl<TipoComponente> dao=new GenericServiceImpl<TipoComponente>();
	//@Inject
	private Componente componente=new Componente();
	
	private TipoComponente tcomponente=new TipoComponente();
	
	public void metodo(){
		 RequestContext.getCurrentInstance().execute("alert('Bienvenido');");
	}
	
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
	
	
	
	
	public GenericService<TipoComponente> getDao() {
		return dao;
	}

	public void setDao(GenericServiceImpl<TipoComponente> dao) {
		this.dao = dao;
	}
	
	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	
	public TipoComponente getTcomponente() {
		return tcomponente;
	}

	public void setTcomponente(TipoComponente tcomponente) {
		this.tcomponente = tcomponente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
