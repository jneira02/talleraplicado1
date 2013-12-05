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
@Table(name="login")
public class Login implements Serializable {
	public Login() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_LOGIN_CLIENTE) {
			return ORM_cliente;
		}
		else if (key == orm.ORMConstants.KEY_LOGIN_CLIENTE_HISTORICO) {
			return ORM_cliente_historico;
		}
		else if (key == orm.ORMConstants.KEY_LOGIN_CUENTA) {
			return ORM_cuenta;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_LOGIN_ID_ADMINISTRADOR) {
			this.id_administrador = (orm.Administrador) owner;
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
	
	@Column(name="id_login", nullable=false)	
	@Id	
	@GeneratedValue(generator="ORM_LOGIN_ID_LOGIN_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_LOGIN_ID_LOGIN_GENERATOR", strategy="increment")	
	private int id_login;
	
	@Column(name="token", nullable=true, unique=true, length=255)	
	private String token;
	
	@Column(name="fecha_logeo", nullable=true, length=20)	
	private String fecha_logeo;
	
	@Column(name="fecha_fin", nullable=true, length=20)	
	private String fecha_fin;
	
	@ManyToOne(targetEntity=orm.Administrador.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_administrador", referencedColumnName="id_administrador", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Administrador id_administrador;
	
	@Column(name="sesionActiva", nullable=false, length=1)	
	private String sesionActiva;
	
	@OneToMany(mappedBy="id_login", targetEntity=orm.Cliente.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cliente = new java.util.HashSet();
	
	@OneToMany(mappedBy="id_login", targetEntity=orm.Cliente_historico.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cliente_historico = new java.util.HashSet();
	
	@OneToMany(mappedBy="id_login", targetEntity=orm.Cuenta.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cuenta = new java.util.HashSet();
	
	/**
	 * Id login
	 */
	private void setId_login(int value) {
		this.id_login = value;
	}
	
	/**
	 * Id login
	 */
	public int getId_login() {
		return id_login;
	}
	
	public int getORMID() {
		return getId_login();
	}
	
	/**
	 * Token de verificacion
	 */
	public void setToken(String value) {
		this.token = value;
	}
	
	/**
	 * Token de verificacion
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Fecha de login
	 */
	public void setFecha_logeo(String value) {
		this.fecha_logeo = value;
	}
	
	/**
	 * Fecha de login
	 */
	public String getFecha_logeo() {
		return fecha_logeo;
	}
	
	public void setSesionActiva(String value) {
		this.sesionActiva = value;
	}
	
	public String getSesionActiva() {
		return sesionActiva;
	}
	
	/**
	 * Fecha de fin del login
	 */
	public void setFecha_fin(String value) {
		this.fecha_fin = value;
	}
	
	/**
	 * Fecha de fin del login
	 */
	public String getFecha_fin() {
		return fecha_fin;
	}
	
	public void setId_administrador(orm.Administrador value) {
		if (id_administrador != null) {
			id_administrador.login.remove(this);
		}
		if (value != null) {
			value.login.add(this);
		}
	}
	
	public orm.Administrador getId_administrador() {
		return id_administrador;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_administrador(orm.Administrador value) {
		this.id_administrador = value;
	}
	
	private orm.Administrador getORM_Id_administrador() {
		return id_administrador;
	}
	
	private void setORM_Cliente(java.util.Set value) {
		this.ORM_cliente = value;
	}
	
	private java.util.Set getORM_Cliente() {
		return ORM_cliente;
	}
	
	@Transient	
	public final orm.ClienteSetCollection cliente = new orm.ClienteSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOGIN_CLIENTE, orm.ORMConstants.KEY_CLIENTE_ID_LOGIN, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Cliente_historico(java.util.Set value) {
		this.ORM_cliente_historico = value;
	}
	
	private java.util.Set getORM_Cliente_historico() {
		return ORM_cliente_historico;
	}
	
	@Transient	
	public final orm.Cliente_historicoSetCollection cliente_historico = new orm.Cliente_historicoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOGIN_CLIENTE_HISTORICO, orm.ORMConstants.KEY_CLIENTE_HISTORICO_ID_LOGIN, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Cuenta(java.util.Set value) {
		this.ORM_cuenta = value;
	}
	
	private java.util.Set getORM_Cuenta() {
		return ORM_cuenta;
	}
	
	@Transient	
	public final orm.CuentaSetCollection cuenta = new orm.CuentaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOGIN_CUENTA, orm.ORMConstants.KEY_CUENTA_ID_LOGIN, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_login());
	}
	
}
