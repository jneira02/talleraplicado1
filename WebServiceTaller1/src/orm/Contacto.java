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

public class Contacto {
	public Contacto() {
	}
	
	private int uid;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private Integer telefono;
	
	private String cargo;
	
	private String fax;
	
	private String area;
	
	/**
	 * Clave primaria
	 */
	private void setUid(int value) {
		this.uid = value;
	}
	
	/**
	 * Clave primaria
	 */
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	/**
	 * Nombre
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * Nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Apellido
	 */
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	/**
	 * Apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Mail
	 */
	public void setEmail(String value) {
		this.email = value;
	}
	
	/**
	 * Mail
	 */
	public String getEmail() {
		return email;
	}
	
	public void setTelefono(int value) {
		setTelefono(new Integer(value));
	}
	
	public void setTelefono(Integer value) {
		this.telefono = value;
	}
	
	public Integer getTelefono() {
		return telefono;
	}
	
	/**
	 * Cargo
	 */
	public void setCargo(String value) {
		this.cargo = value;
	}
	
	/**
	 * Cargo
	 */
	public String getCargo() {
		return cargo;
	}
	
	/**
	 * Fax
	 */
	public void setFax(String value) {
		this.fax = value;
	}
	
	/**
	 * Fax
	 */
	public String getFax() {
		return fax;
	}
	
	/**
	 * Area
	 */
	public void setArea(String value) {
		this.area = value;
	}
	
	/**
	 * Area
	 */
	public String getArea() {
		return area;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
