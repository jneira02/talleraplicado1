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

public class Administrador {
	public Administrador() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_ADMINISTRADOR_LOGIN) {
			return ORM_login;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_administrador;
	
	private String user;
	
	private String password;
	
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
	
	public final orm.LoginSetCollection login = new orm.LoginSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_ADMINISTRADOR_LOGIN, orm.ORMConstants.KEY_LOGIN_ID_ADMINISTRADOR, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_administrador());
	}
	
}
