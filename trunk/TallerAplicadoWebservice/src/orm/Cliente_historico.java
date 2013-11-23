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

public class Cliente_historico {
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
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_cliente_hist;
	
	private String nombres;
	
	private String rut;
	
	private String apellido_materno;
	
	private String apellido_paterno;
	
	private String telefono;
	
	private String email;
	
	private String direccion;
	
	private String fecha_modificacion;
	
	private orm.Login id_login;
	
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
