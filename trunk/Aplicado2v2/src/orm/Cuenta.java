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
@Table(name="cuenta")
public class Cuenta implements Serializable {
	public Cuenta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CUENTA_CONSUMO) {
			return ORM_consumo;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CUENTA_ID_CLIENTE) {
			this.id_cliente = (orm.Cliente) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_CUENTA_ID_LOGIN) {
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
	
	@Column(name="esActiva", nullable=false, length=1)	
	private String esActiva;
	
	@Column(name="id_cuenta", nullable=false)	
	@Id	
	@GeneratedValue(generator="ORM_CUENTA_ID_CUENTA_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_CUENTA_ID_CUENTA_GENERATOR", strategy="increment")	
	private int id_cuenta;
	
	@ManyToOne(targetEntity=orm.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_cliente", referencedColumnName="id_cliente", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Cliente id_cliente;
	
	@ManyToOne(targetEntity=orm.Login.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_login", referencedColumnName="id_login", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Login id_login;
	
	@OneToMany(mappedBy="id_cuenta", targetEntity=orm.Consumo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_consumo = new java.util.HashSet();
	
	public void setEsActiva(String value) {
		this.esActiva = value;
	}
	
	public String getEsActiva() {
		return esActiva;
	}
	
	private void setId_cuenta(int value) {
		this.id_cuenta = value;
	}
	
	public int getId_cuenta() {
		return id_cuenta;
	}
	
	public int getORMID() {
		return getId_cuenta();
	}
	
	public void setId_cliente(orm.Cliente value) {
		if (id_cliente != null) {
			id_cliente.cuenta.remove(this);
		}
		if (value != null) {
			value.cuenta.add(this);
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
	
	public void setId_login(orm.Login value) {
		if (id_login != null) {
			id_login.cuenta.remove(this);
		}
		if (value != null) {
			value.cuenta.add(this);
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
	
	private void setORM_Consumo(java.util.Set value) {
		this.ORM_consumo = value;
	}
	
	private java.util.Set getORM_Consumo() {
		return ORM_consumo;
	}
	
	@Transient	
	public final orm.ConsumoSetCollection consumo = new orm.ConsumoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CUENTA_CONSUMO, orm.ORMConstants.KEY_CONSUMO_ID_CUENTA, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_cuenta());
	}
	
}
