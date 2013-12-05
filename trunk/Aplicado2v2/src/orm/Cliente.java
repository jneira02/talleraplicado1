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
/**
 * Tabla de cliente
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="cliente")
public class Cliente implements Serializable {
	public Cliente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CLIENTE_CLIENTE_HISTORICO) {
			return ORM_cliente_historico;
		}
		else if (key == orm.ORMConstants.KEY_CLIENTE_CUENTA) {
			return ORM_cuenta;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CLIENTE_ID_LOGIN) {
			this.id_login = (orm.Login) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="id_cliente", nullable=false)	
	@Id	
	@GeneratedValue(generator="ORM_CLIENTE_ID_CLIENTE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_CLIENTE_ID_CLIENTE_GENERATOR", strategy="increment")	
	private int id_cliente;
	
	@Column(name="rut", nullable=false, unique=true, length=20)	
	private String rut;
	
	@Column(name="nombres", nullable=true, length=100)	
	private String nombres;
	
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
	
	@Column(name="fecha_creacion", nullable=true, length=20)	
	private String fecha_creacion;
	
	@ManyToOne(targetEntity=orm.Login.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_login", referencedColumnName="id_login", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Login id_login;
	
	@OneToMany(mappedBy="id_cliente", targetEntity=orm.Cliente_historico.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cliente_historico = new java.util.HashSet();
	
	@OneToMany(mappedBy="id_cliente", targetEntity=orm.Cuenta.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cuenta = new java.util.HashSet();
	
	private void setId_cliente(int value) {
		this.id_cliente = value;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public int getORMID() {
		return getId_cliente();
	}
	
	/**
	 * Rut de cliente
	 */
	public void setRut(String value) {
		this.rut = value;
	}
	
	/**
	 * Rut de cliente
	 */
	public String getRut() {
		return rut;
	}
	
	/**
	 * Nombres de cliente
	 */
	public void setNombres(String value) {
		this.nombres = value;
	}
	
	/**
	 * Nombres de cliente
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
	
	/**
	 * Apellido paterno
	 */
	public void setApellido_paterno(String value) {
		this.apellido_paterno = value;
	}
	
	/**
	 * Apellido paterno
	 */
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	
	/**
	 * Telefono de cliente
	 */
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	/**
	 * Telefono de cliente
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Email de cliente
	 */
	public void setEmail(String value) {
		this.email = value;
	}
	
	/**
	 * Email de cliente
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Direccion o domicilio de cliente
	 */
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	/**
	 * Direccion o domicilio de cliente
	 */
	public String getDireccion() {
		return direccion;
	}
	
	public void setFecha_creacion(String value) {
		this.fecha_creacion = value;
	}
	
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	
	public void setId_login(orm.Login value) {
		if (id_login != null) {
			id_login.cliente.remove(this);
		}
		if (value != null) {
			value.cliente.add(this);
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
	
	private void setORM_Cliente_historico(java.util.Set value) {
		this.ORM_cliente_historico = value;
	}
	
	private java.util.Set getORM_Cliente_historico() {
		return ORM_cliente_historico;
	}
	
	@Transient	
	public final orm.Cliente_historicoSetCollection cliente_historico = new orm.Cliente_historicoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CLIENTE_CLIENTE_HISTORICO, orm.ORMConstants.KEY_CLIENTE_HISTORICO_ID_CLIENTE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Cuenta(java.util.Set value) {
		this.ORM_cuenta = value;
	}
	
	private java.util.Set getORM_Cuenta() {
		return ORM_cuenta;
	}
	
	@Transient	
	public final orm.CuentaSetCollection cuenta = new orm.CuentaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CLIENTE_CUENTA, orm.ORMConstants.KEY_CUENTA_ID_CLIENTE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_cliente());
	}
	
}
