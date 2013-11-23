package spring3.form;

public class Consumo implements java.io.Serializable{
	/** The tipo_servicio. */
	private String tipo_servicio;
	
	/** The unidad_servicio. */
	private String unidad_servicio;
	
	/** The monto_unidad. */
	private int monto_unidad;
	
	/** The cantidad_unidades. */
	private int cantidad_unidades;
	
	/** The monto_total. */
	private int monto_total;
	
	/** The esta_pagado. */
	private String esta_pagado;
	
	/** The fecha_vencimiento. */
	private String fecha_vencimiento;
	
	/** The cliente vo. */
	private Cuenta cuenta;

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getUnidad_servicio() {
		return unidad_servicio;
	}

	public void setUnidad_servicio(String unidad_servicio) {
		this.unidad_servicio = unidad_servicio;
	}

	public int getMonto_unidad() {
		return monto_unidad;
	}

	public void setMonto_unidad(int monto_unidad) {
		this.monto_unidad = monto_unidad;
	}

	public int getCantidad_unidades() {
		return cantidad_unidades;
	}

	public void setCantidad_unidades(int cantidad_unidades) {
		this.cantidad_unidades = cantidad_unidades;
	}

	public int getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(int monto_total) {
		this.monto_total = monto_total;
	}

	public String getEsta_pagado() {
		return esta_pagado;
	}

	public void setEsta_pagado(String esta_pagado) {
		this.esta_pagado = esta_pagado;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	

	public Consumo(String tipo_servicio, String unidad_servicio,
			int monto_unidad, int cantidad_unidades, int monto_total,
			String esta_pagado, String fecha_vencimiento, Cuenta cuenta) {
		super();
		this.tipo_servicio = tipo_servicio;
		this.unidad_servicio = unidad_servicio;
		this.monto_unidad = monto_unidad;
		this.cantidad_unidades = cantidad_unidades;
		this.monto_total = monto_total;
		this.esta_pagado = esta_pagado;
		this.fecha_vencimiento = fecha_vencimiento;
		this.cuenta = cuenta;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Consumo() {
		super();
	}
	
	
}
