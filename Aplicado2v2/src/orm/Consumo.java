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
 * Datos de consumo de cliente
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="consumo")
public class Consumo implements Serializable {
	public Consumo() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CONSUMO_ID_CUENTA) {
			this.id_cuenta = (orm.Cuenta) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="id_consumo", nullable=false)	
	@Id	
	@GeneratedValue(generator="ORM_CONSUMO_ID_CONSUMO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_CONSUMO_ID_CONSUMO_GENERATOR", strategy="increment")	
	private int id_consumo;
	
	@Column(name="tipo_servicio", nullable=true, length=50)	
	private String tipo_servicio;
	
	@Column(name="unidad_servicio", nullable=true, length=20)	
	private String unidad_servicio;
	
	@Column(name="monto_unidad", nullable=true, length=10)	
	private Integer monto_unidad;
	
	@Column(name="cantidad_unidades", nullable=true, length=10)	
	private Integer cantidad_unidades;
	
	@Column(name="monto_total", nullable=true, length=10)	
	private Integer monto_total;
	
	@Column(name="esta_pagado", nullable=true, length=1)	
	private String esta_pagado;
	
	@Column(name="fecha_vencimiento", nullable=false, length=20)	
	private String fecha_vencimiento;
	
	@Column(name="id_cliente", nullable=false, length=10)	
	private int id_cliente;
	
	@ManyToOne(targetEntity=orm.Cuenta.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="id_cuenta", referencedColumnName="id_cuenta", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private orm.Cuenta id_cuenta;
	
	@Column(name="monto_fijo", nullable=true, length=10)	
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
