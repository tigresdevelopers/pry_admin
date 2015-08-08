package com.tigers.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.tigers.entities.Componente;
import com.tigers.entities.Menu;
import com.tigers.entities.Rol;
import com.tigers.entities.TipoComponente;
import com.tigers.entities.Usuario;
import com.tigers.entities.UsuarioPK;
import com.tigers.service.GenericService;
import com.tigers.service.GenericServiceImpl;
import com.tigers.util.FileUtil;
import com.tigers.util.NavbarUtil;
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
	
	public String  getMenu() throws Exception{
		
		simulateUserLogged();//Simulamos ellogueo de un usuario
		
		
		String foto=Faces.getContext().getContextPath()+"/resources/img/"+((Usuario)Faces.getSessionAttribute(Faces.ATTRIBUTE_USER)).getFoto();
		
		System.out.println(foto);
		
		return NavbarUtil.getMenu(new GenericServiceImpl<Menu>().listAll(Menu.class),foto);
	}
	
	public List<Menu> listarMenus(){
		return new GenericServiceImpl<Menu>().listAll(Menu.class);
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
	
	
	public void simulateUserLogged(){
		
		Usuario u=new Usuario();
		UsuarioPK pk=new UsuarioPK();
		pk.setIdusuario("E000");pk.setRolIdrol(1);
		Rol rol=new Rol();
		rol.setIdrol(1);
		rol.setDescripcion("Administrador");
		
		u.setId(pk);
		u.setLogin("leonxandercs@gmail.com");
		u.setPassword("123456");
		u.setRol(rol);
		u.setFoto("carnet.JPG");
		
		Faces.setSessionAttribute(Faces.ATTRIBUTE_USER,u);
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
