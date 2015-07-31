package com.pantera.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CLIENTE database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idcliente;

	private String activo;

	@Column(name="APE_MA")
	private String apeMa;

	@Column(name="APE_PA")
	private String apePa;

	private String celular;

	private String dni;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_NACIMIENTO")
	private Date fecNacimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_REGISTRO")
	private Date fecRegistro;

	private String nombre;

	private String sexo;

	private String telefono;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="USUARIO_IDUSUARIO", referencedColumnName="IDUSUARIO"),
		@JoinColumn(name="USUARIO_ROL_IDROL", referencedColumnName="ROL_IDROL")
		})
	private Usuario usuario;

	//bi-directional many-to-one association to PedidoCabe
	@OneToMany(mappedBy="cliente")
	private List<PedidoCabe> pedidoCabes;

	//bi-directional many-to-many association to Producto
	@ManyToMany(mappedBy="clientes")
	private List<Producto> productos;

	public Cliente() {
	}

	public String getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApeMa() {
		return this.apeMa;
	}

	public void setApeMa(String apeMa) {
		this.apeMa = apeMa;
	}

	public String getApePa() {
		return this.apePa;
	}

	public void setApePa(String apePa) {
		this.apePa = apePa;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PedidoCabe> getPedidoCabes() {
		return this.pedidoCabes;
	}

	public void setPedidoCabes(List<PedidoCabe> pedidoCabes) {
		this.pedidoCabes = pedidoCabes;
	}

	public PedidoCabe addPedidoCabe(PedidoCabe pedidoCabe) {
		getPedidoCabes().add(pedidoCabe);
		pedidoCabe.setCliente(this);

		return pedidoCabe;
	}

	public PedidoCabe removePedidoCabe(PedidoCabe pedidoCabe) {
		getPedidoCabes().remove(pedidoCabe);
		pedidoCabe.setCliente(null);

		return pedidoCabe;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}