package domain;

public class ConsumoVO {

	private int id_consumo;
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
    private CuentaVO cuentaVO;
   
   
   
    /**
     * Gets the cuenta vo.
     *
     * @return the cuenta vo
     */
    public CuentaVO getCuentaVO() {
            return cuentaVO;
    }

    /**
     * Sets the cuenta vo.
     *
     * @param cuentaVO the new cuenta vo
     */
    public void setCuentaVO(CuentaVO cuentaVO) {
            this.cuentaVO = cuentaVO;
    }

    /**
     * Instantiates a new consumo vo.
     *
     * @param tipo_servicio the tipo_servicio
     * @param unidad_servicio the unidad_servicio
     * @param monto_unidad the monto_unidad
     * @param cantidad_unidades the cantidad_unidades
     * @param monto_total the monto_total
     * @param esta_pagado the esta_pagado
     * @param fecha_vencimiento the fecha_vencimiento
     * @param cuentaVO the cuenta vo
     */
    public ConsumoVO(String tipo_servicio, String unidad_servicio,
                    int monto_unidad, int cantidad_unidades, int monto_total,
                    String esta_pagado, String fecha_vencimiento, CuentaVO cuentaVO) {
            super();
            this.tipo_servicio = tipo_servicio;
            this.unidad_servicio = unidad_servicio;
            this.monto_unidad = monto_unidad;
            this.cantidad_unidades = cantidad_unidades;
            this.monto_total = monto_total;
            this.esta_pagado = esta_pagado;
            this.fecha_vencimiento = fecha_vencimiento;
            this.cuentaVO = cuentaVO;
    }

    /**
     * Gets the tipo_servicio.
     *
     * @return the tipo_servicio
     */
    public String getTipo_servicio() {
            return tipo_servicio;
    }
   
    /**
     * Sets the tipo_servicio.
     *
     * @param tipo_servicio the new tipo_servicio
     */
    public void setTipo_servicio(String tipo_servicio) {
            this.tipo_servicio = tipo_servicio;
    }
   
    /**
     * Gets the unidad_servicio.
     *
     * @return the unidad_servicio
     */
    public String getUnidad_servicio() {
            return unidad_servicio;
    }
   
    /**
     * Sets the unidad_servicio.
     *
     * @param unidad_servicio the new unidad_servicio
     */
    public void setUnidad_servicio(String unidad_servicio) {
            this.unidad_servicio = unidad_servicio;
    }
   
    /**
     * Gets the monto_unidad.
     *
     * @return the monto_unidad
     */
    public int getMonto_unidad() {
            return monto_unidad;
    }
   
    /**
     * Sets the monto_unidad.
     *
     * @param monto_unidad the new monto_unidad
     */
    public void setMonto_unidad(int monto_unidad) {
            this.monto_unidad = monto_unidad;
    }
   
    /**
     * Gets the cantidad_unidades.
     *
     * @return the cantidad_unidades
     */
    public int getCantidad_unidades() {
            return cantidad_unidades;
    }
   
    /**
     * Sets the cantidad_unidades.
     *
     * @param cantidad_unidades the new cantidad_unidades
     */
    public void setCantidad_unidades(int cantidad_unidades) {
            this.cantidad_unidades = cantidad_unidades;
    }
   
    /**
     * Gets the monto_total.
     *
     * @return the monto_total
     */
    public int getMonto_total() {
            return monto_total;
    }
   
    /**
     * Sets the monto_total.
     *
     * @param monto_total the new monto_total
     */
    public void setMonto_total(int monto_total) {
            this.monto_total = monto_total;
    }
   
    /**
     * Gets the esta_pagado.
     *
     * @return the esta_pagado
     */
    public String getEsta_pagado() {
            return esta_pagado;
    }
   
    /**
     * Sets the esta_pagado.
     *
     * @param esta_pagado the new esta_pagado
     */
    public void setEsta_pagado(String esta_pagado) {
            this.esta_pagado = esta_pagado;
    }
   
    /**
     * Gets the fecha_vencimiento.
     *
     * @return the fecha_vencimiento
     */
    public String getFecha_vencimiento() {
            return fecha_vencimiento;
    }
   
    /**
     * Sets the fecha_vencimiento.
     *
     * @param fecha_vencimiento the new fecha_vencimiento
     */
    public void setFecha_vencimiento(String fecha_vencimiento) {
            this.fecha_vencimiento = fecha_vencimiento;
    }
   
    /**
     * Instantiates a new consumo vo.
     */
    public ConsumoVO() {
            super();
    }

	public ConsumoVO(int id_consumo, String tipo_servicio,
			String unidad_servicio, int monto_unidad, int cantidad_unidades,
			int monto_total, String esta_pagado, String fecha_vencimiento,
			CuentaVO cuentaVO) {
		super();
		this.id_consumo = id_consumo;
		this.tipo_servicio = tipo_servicio;
		this.unidad_servicio = unidad_servicio;
		this.monto_unidad = monto_unidad;
		this.cantidad_unidades = cantidad_unidades;
		this.monto_total = monto_total;
		this.esta_pagado = esta_pagado;
		this.fecha_vencimiento = fecha_vencimiento;
		this.cuentaVO = cuentaVO;
	}

	public int getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(int id_consumo) {
		this.id_consumo = id_consumo;
	}
	
	


}
