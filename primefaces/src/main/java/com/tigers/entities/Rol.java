package com.tigers.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="SQ_GENERATOR_ROL",strategy="sequence",parameters={@Parameter(name="sequence",value="sq_rol")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR_ROL")
	private int idrol;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	//bi-directional many-to-many association to Menu
	@ManyToMany(mappedBy="rols")
	private List<Menu> menus;

	public Rol() {
	}

	public int getIdrol() {
		return this.idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}