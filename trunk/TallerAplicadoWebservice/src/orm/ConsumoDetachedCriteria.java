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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ConsumoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_consumo;
	public final StringExpression tipo_servicio;
	public final StringExpression unidad_servicio;
	public final IntegerExpression monto_unidad;
	public final IntegerExpression cantidad_unidades;
	public final IntegerExpression monto_total;
	public final StringExpression esta_pagado;
	public final StringExpression fecha_vencimiento;
	public final IntegerExpression id_cliente;
	public final IntegerExpression monto_fijo;
	
	public ConsumoDetachedCriteria() {
		super(orm.Consumo.class, orm.ConsumoCriteria.class);
		id_consumo = new IntegerExpression("id_consumo", this.getDetachedCriteria());
		tipo_servicio = new StringExpression("tipo_servicio", this.getDetachedCriteria());
		unidad_servicio = new StringExpression("unidad_servicio", this.getDetachedCriteria());
		monto_unidad = new IntegerExpression("monto_unidad", this.getDetachedCriteria());
		cantidad_unidades = new IntegerExpression("cantidad_unidades", this.getDetachedCriteria());
		monto_total = new IntegerExpression("monto_total", this.getDetachedCriteria());
		esta_pagado = new StringExpression("esta_pagado", this.getDetachedCriteria());
		fecha_vencimiento = new StringExpression("fecha_vencimiento", this.getDetachedCriteria());
		id_cliente = new IntegerExpression("id_cliente", this.getDetachedCriteria());
		monto_fijo = new IntegerExpression("monto_fijo", this.getDetachedCriteria());
	}
	
	public ConsumoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ConsumoCriteria.class);
		id_consumo = new IntegerExpression("id_consumo", this.getDetachedCriteria());
		tipo_servicio = new StringExpression("tipo_servicio", this.getDetachedCriteria());
		unidad_servicio = new StringExpression("unidad_servicio", this.getDetachedCriteria());
		monto_unidad = new IntegerExpression("monto_unidad", this.getDetachedCriteria());
		cantidad_unidades = new IntegerExpression("cantidad_unidades", this.getDetachedCriteria());
		monto_total = new IntegerExpression("monto_total", this.getDetachedCriteria());
		esta_pagado = new StringExpression("esta_pagado", this.getDetachedCriteria());
		fecha_vencimiento = new StringExpression("fecha_vencimiento", this.getDetachedCriteria());
		id_cliente = new IntegerExpression("id_cliente", this.getDetachedCriteria());
		monto_fijo = new IntegerExpression("monto_fijo", this.getDetachedCriteria());
	}
	
	public CuentaDetachedCriteria createId_cuentaCriteria() {
		return new CuentaDetachedCriteria(createCriteria("id_cuenta"));
	}
	
	public Consumo uniqueConsumo(PersistentSession session) {
		return (Consumo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Consumo[] listConsumo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Consumo[]) list.toArray(new Consumo[list.size()]);
	}
}

