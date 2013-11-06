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

public class Cliente_historicoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_cliente_hist;
	public final StringExpression nombres;
	public final StringExpression rut;
	public final StringExpression apellido_materno;
	public final StringExpression apellido_paterno;
	public final StringExpression telefono;
	public final StringExpression email;
	public final StringExpression direccion;
	public final StringExpression fecha_modificacion;
	
	public Cliente_historicoDetachedCriteria() {
		super(orm.Cliente_historico.class, orm.Cliente_historicoCriteria.class);
		id_cliente_hist = new IntegerExpression("id_cliente_hist", this.getDetachedCriteria());
		nombres = new StringExpression("nombres", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		apellido_materno = new StringExpression("apellido_materno", this.getDetachedCriteria());
		apellido_paterno = new StringExpression("apellido_paterno", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		fecha_modificacion = new StringExpression("fecha_modificacion", this.getDetachedCriteria());
	}
	
	public Cliente_historicoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.Cliente_historicoCriteria.class);
		id_cliente_hist = new IntegerExpression("id_cliente_hist", this.getDetachedCriteria());
		nombres = new StringExpression("nombres", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		apellido_materno = new StringExpression("apellido_materno", this.getDetachedCriteria());
		apellido_paterno = new StringExpression("apellido_paterno", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		fecha_modificacion = new StringExpression("fecha_modificacion", this.getDetachedCriteria());
	}
	
	public LoginDetachedCriteria createId_loginCriteria() {
		return new LoginDetachedCriteria(createCriteria("id_login"));
	}
	
	public ClienteDetachedCriteria createId_clienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("id_cliente"));
	}
	
	public Cliente_historico uniqueCliente_historico(PersistentSession session) {
		return (Cliente_historico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente_historico[] listCliente_historico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente_historico[]) list.toArray(new Cliente_historico[list.size()]);
	}
}

