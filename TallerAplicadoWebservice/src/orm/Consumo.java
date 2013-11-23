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

/**
 * Datos de consumo de cliente
 */
public class Consumo {
	public Consumo() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CONSUMO_ID_CUENTA) {
			this.id_cuenta = (orm.Cuenta) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_consumo;
	
	private String tipo_servicio;
	
	private String unidad_servicio;
	
	private Integer monto_unidad;
	
	private Integer cantidad_unidades;
	
	private Integer monto_total;
	
	private String esta_pagado;
	
	private String fecha_vencimiento;
	
	private int id_cliente;
	
	private orm.Cuenta id_cuenta;
	
	private Integer monto_fijo;
	
	private void setId_consumo(int value) {
		this.id_consumo = value;
	}
	
	public int getId_consumo() {
		return id_consumo;
	}
	
	public int getORMID() {
		return getId_consumo();
	}
	
	/**
	 * Tipo de servicio
	 */
	public void setTipo_servicio(String value) {
		this.tipo_servicio = value;
	}
	
	/**
	 * Tipo de servicio
	 */
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	
	/**
	 * Unidad de medida del servicio
	 */
	public void setUnidad_servicio(String value) {
		this.unidad_servicio = value;
	}
	
	/**
	 * Unidad de medida del servicio
	 */
	public String getUnidad_servicio() {
		return unidad_servicio;
	}
	
	/**
	 * Multiplicador de unidades de servicio cobrado
	 */
	public void setMonto_unidad(int value) {
		setMonto_unidad(new Integer(value));
	}
	
	/**
	 * Multiplicador de unidades de servicio cobrado
	 */
	public void setMonto_unidad(Integer value) {
		this.monto_unidad = value;
	}
	
	/**
	 * Multiplicador de unidades de servicio cobrado
	 */
	public Integer getMonto_unidad() {
		return monto_unidad;
	}
	
	/**
	 * Cantidad de unidades de servicio cobradas
	 */
	public void setCantidad_unidades(int value) {
		setCantidad_unidades(new Integer(value));
	}
	
	/**
	 * Cantidad de unidades de servicio cobradas
	 */
	public void setCantidad_unidades(Integer value) {
		this.cantidad_unidades = value;
	}
	
	/**
	 * Cantidad de unidades de servicio cobradas
	 */
	public Integer getCantidad_unidades() {
		return cantidad_unidades;
	}
	
	/**
	 * Multiplicacion entre cantidad unidades y monto servicio
	 */
	public void setMonto_total(int value) {
		setMonto_total(new Integer(value));
	}
	
	/**
	 * Multiplicacion entre cantidad unidades y monto servicio
	 */
	public void setMonto_total(Integer value) {
		this.monto_total = value;
	}
	
	/**
	 * Multiplicacion entre cantidad unidades y monto servicio
	 */
	public Integer getMonto_total() {
		return monto_total;
	}
	
	/**
	 * Identificador de pago
	 */
	public void setEsta_pagado(String value) {
		this.esta_pagado = value;
	}
	
	/**
	 * Identificador de pago
	 */
	public String getEsta_pagado() {
		return esta_pagado;
	}
	
	/**
	 * Fecha vencimiento de cuenta
	 */
	public void setFecha_vencimiento(String value) {
		this.fecha_vencimiento = value;
	}
	
	/**
	 * Fecha vencimiento de cuenta
	 */
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	
	public void setId_cliente(int value) {
		this.id_cliente = value;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setMonto_fijo(int value) {
		setMonto_fijo(new Integer(value));
	}
	
	public void setMonto_fijo(Integer value) {
		this.monto_fijo = value;
	}
	
	public Integer getMonto_fijo() {
		return monto_fijo;
	}
	
	public void setId_cuenta(orm.Cuenta value) {
		if (id_cuenta != null) {
			id_cuenta.consumo.remove(this);
		}
		if (value != null) {
			value.consumo.add(this);
		}
	}
	
	public orm.Cuenta getId_cuenta() {
		return id_cuenta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_cuenta(orm.Cuenta value) {
		this.id_cuenta = value;
	}
	
	private orm.Cuenta getORM_Id_cuenta() {
		return id_cuenta;
	}
	
	public String toString() {
		return String.valueOf(getId_consumo());
	}
	
}
