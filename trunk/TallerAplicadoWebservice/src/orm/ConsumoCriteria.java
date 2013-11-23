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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ConsumoCriteria extends AbstractORMCriteria {
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
	
	public ConsumoCriteria(Criteria criteria) {
		super(criteria);
		id_consumo = new IntegerExpression("id_consumo", this);
		tipo_servicio = new StringExpression("tipo_servicio", this);
		unidad_servicio = new StringExpression("unidad_servicio", this);
		monto_unidad = new IntegerExpression("monto_unidad", this);
		cantidad_unidades = new IntegerExpression("cantidad_unidades", this);
		monto_total = new IntegerExpression("monto_total", this);
		esta_pagado = new StringExpression("esta_pagado", this);
		fecha_vencimiento = new StringExpression("fecha_vencimiento", this);
		id_cliente = new IntegerExpression("id_cliente", this);
		monto_fijo = new IntegerExpression("monto_fijo", this);
	}
	
	public ConsumoCriteria(PersistentSession session) {
		this(session.createCriteria(Consumo.class));
	}
	
	public ConsumoCriteria() throws PersistentException {
		this(orm.BDtalleraplicadoPersistentManager.instance().getSession());
	}
	
	public CuentaCriteria createId_cuentaCriteria() {
		return new CuentaCriteria(createCriteria("id_cuenta"));
	}
	
	public Consumo uniqueConsumo() {
		return (Consumo) super.uniqueResult();
	}
	
	public Consumo[] listConsumo() {
		java.util.List list = super.list();
		return (Consumo[]) list.toArray(new Consumo[list.size()]);
	}
}

