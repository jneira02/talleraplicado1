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

public class Login {
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
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_login;
	
	private String token;
	
	private String fecha_logeo;
	
	private String fecha_fin;
	
	private orm.Administrador id_administrador;
	
	private String sesionActiva;
	
	private java.util.Set ORM_cliente = new java.util.HashSet();
	
	private java.util.Set ORM_cliente_historico = new java.util.HashSet();
	
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
	
	public final orm.ClienteSetCollection cliente = new orm.ClienteSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOGIN_CLIENTE, orm.ORMConstants.KEY_CLIENTE_ID_LOGIN, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Cliente_historico(java.util.Set value) {
		this.ORM_cliente_historico = value;
	}
	
	private java.util.Set getORM_Cliente_historico() {
		return ORM_cliente_historico;
	}
	
	public final orm.Cliente_historicoSetCollection cliente_historico = new orm.Cliente_historicoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOGIN_CLIENTE_HISTORICO, orm.ORMConstants.KEY_CLIENTE_HISTORICO_ID_LOGIN, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Cuenta(java.util.Set value) {
		this.ORM_cuenta = value;
	}
	
	private java.util.Set getORM_Cuenta() {
		return ORM_cuenta;
	}
	
	public final orm.CuentaSetCollection cuenta = new orm.CuentaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOGIN_CUENTA, orm.ORMConstants.KEY_CUENTA_ID_LOGIN, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_login());
	}
	
}
