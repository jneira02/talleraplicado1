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
@Table(name="administrador")
public class Administrador implements Serializable {
	public Administrador() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_ADMINISTRADOR_LOGIN) {
			return ORM_login;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="id_administrador", nullable=false)	
	@Id	
	@GeneratedValue(generator="ORM_ADMINISTRADOR_ID_ADMINISTRADOR_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_ADMINISTRADOR_ID_ADMINISTRADOR_GENERATOR", strategy="increment")	
	private int id_administrador;
	
	@Column(name="`user`", nullable=false, unique=true, length=50)	
	private String user;
	
	@Column(name="password", nullable=false, length=100)	
	private String password;
	
	@OneToMany(mappedBy="id_administrador", targetEntity=orm.Login.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_login = new java.util.HashSet();
	
	private void setId_administrador(int value) {
		this.id_administrador = value;
	}
	
	public int getId_administrador() {
		return id_administrador;
	}
	
	public int getORMID() {
		return getId_administrador();
	}
	
	/**
	 * User
	 */
	public void setUser(String value) {
		this.user = value;
	}
	
	/**
	 * User
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Contrasena
	 */
	public void setPassword(String value) {
		this.password = value;
	}
	
	/**
	 * Contrasena
	 */
	public String getPassword() {
		return password;
	}
	
	private void setORM_Login(java.util.Set value) {
		this.ORM_login = value;
	}
	
	private java.util.Set getORM_Login() {
		return ORM_login;
	}
	
	@Transient	
	public final orm.LoginSetCollection login = new orm.LoginSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_ADMINISTRADOR_LOGIN, orm.ORMConstants.KEY_LOGIN_ID_ADMINISTRADOR, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_administrador());
	}
	
}
