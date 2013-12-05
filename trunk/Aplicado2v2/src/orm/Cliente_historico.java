/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="cliente_historico")
public class Cliente_historico implements Serializable {
	public Cliente_historico() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CLIENTE_HISTORICO_ID_LOGIN) {
			this.id_login = (orm.Login) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_CLIENTE_HISTORICO_ID_CLIENTE) {
			this.id_cliente = (orm.Cliente) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="id_cliente_hist", nullable=false)	
	@Id	
	@GeneratedValue(generator="ORM_CLIENTE_HISTORICO_ID_CLIENTE_HIST_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_CLIENTE_HISTORICO_ID_CLIENTE_HIST_GENERATOR", strategy="increment")	
	private int id_cliente_hist;
	
	@Column(name="nombres", nullable=true, length=100)	
	private String nombres;
	
	@Column(name="rut", nullable=true, length=20)	
	private String rut;
	
	@Column(name="apellido_materno", nullable=true, length=50)	
	private String apellido_materno;
	
	@Column(name="apellido_paterno", nullable=true, length=50)	
	private String apellido_paterno;
	
	@Column(name="telefono", nullable=true, length=20)	
	private String telefono;
	
	@Column(name="email", nullable=true, length=100)	
	private String email;
	
	@Column(name="direccion", nullable=true, length=100)	
	private String direccion;
	
	@Column(name="fecha_modificacion", nullable=true, length=20)	
	private String fecha_modificacion;
	
	@ManyToOne(targetEntity=orm.Login.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_login", referencedColumnName="id_login", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Login id_login;
	
	@ManyToOne(targetEntity=orm.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_cliente", referencedColumnName="id_cliente", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Cliente id_cliente;
	
	/**
	 * Id cliente
	 */
	private void setId_cliente_hist(int value) {
		this.id_cliente_hist = value;
	}
	
	/**
	 * Id cliente
	 */
	public int getId_cliente_hist() {
		return id_cliente_hist;
	}
	
	public int getORMID() {
		return getId_cliente_hist();
	}
	
	/**
	 * Rut
	 */
	public void setRut(String value) {
		this.rut = value;
	}
	
	/**
	 * Rut
	 */
	public String getRut() {
		return rut;
	}
	
	/**
	 * Nombres
	 */
	public void setNombres(String value) {
		this.nombres = value;
	}
	
	/**
	 * Nombres
	 */
	public String getNombres() {
		return nombres;
	}
	
	/**
	 * Apellido materno
	 */
	public void setApellido_materno(String value) {
		this.apellido_materno = value;
	}
	
	/**
	 * Apellido materno
	 */
	public String getApellido_materno() {
		return apellido_materno;
	}
	
	public void setApellido_paterno(String value) {
		this.apellido_paterno = value;
	}
	
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	
	/**
	 * Telefono
	 */
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	/**
	 * Telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Email
	 */
	public void setEmail(String value) {
		this.email = value;
	}
	
	/**
	 * Email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Direccion
	 */
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	/**
	 * Direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Fecha de modificacion
	 */
	public void setFecha_modificacion(String value) {
		this.fecha_modificacion = value;
	}
	
	/**
	 * Fecha de modificacion
	 */
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}
	
	public void setId_login(orm.Login value) {
		if (id_login != null) {
			id_login.cliente_historico.remove(this);
		}
		if (value != null) {
			value.cliente_historico.add(this);
		}
	}
	
	public orm.Login getId_login() {
		return id_login;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_login(orm.Login value) {
		this.id_login = value;
	}
	
	private orm.Login getORM_Id_login() {
		return id_login;
	}
	
	public void setId_cliente(orm.Cliente value) {
		if (id_cliente != null) {
			id_cliente.cliente_historico.remove(this);
		}
		if (value != null) {
			value.cliente_historico.add(this);
		}
	}
	
	public orm.Cliente getId_cliente() {
		return id_cliente;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_cliente(orm.Cliente value) {
		this.id_cliente = value;
	}
	
	private orm.Cliente getORM_Id_cliente() {
		return id_cliente;
	}
	
	public String toString() {
		return String.valueOf(getId_cliente_hist());
	}
	
}
