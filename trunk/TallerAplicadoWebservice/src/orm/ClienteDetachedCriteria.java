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

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_cliente;
	public final StringExpression rut;
	public final StringExpression nombres;
	public final StringExpression apellido_materno;
	public final StringExpression apellido_paterno;
	public final StringExpression telefono;
	public final StringExpression email;
	public final StringExpression direccion;
	public final StringExpression fecha_creacion;
	
	public ClienteDetachedCriteria() {
		super(orm.Cliente.class, orm.ClienteCriteria.class);
		id_cliente = new IntegerExpression("id_cliente", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		nombres = new StringExpression("nombres", this.getDetachedCriteria());
		apellido_materno = new StringExpression("apellido_materno", this.getDetachedCriteria());
		apellido_paterno = new StringExpression("apellido_paterno", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		fecha_creacion = new StringExpression("fecha_creacion", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ClienteCriteria.class);
		id_cliente = new IntegerExpression("id_cliente", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		nombres = new StringExpression("nombres", this.getDetachedCriteria());
		apellido_materno = new StringExpression("apellido_materno", this.getDetachedCriteria());
		apellido_paterno = new StringExpression("apellido_paterno", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		fecha_creacion = new StringExpression("fecha_creacion", this.getDetachedCriteria());
	}
	
	public LoginDetachedCriteria createId_loginCriteria() {
		return new LoginDetachedCriteria(createCriteria("id_login"));
	}
	
	public Cliente_historicoDetachedCriteria createCliente_historicoCriteria() {
		return new Cliente_historicoDetachedCriteria(createCriteria("ORM_Cliente_historico"));
	}
	
	public CuentaDetachedCriteria createCuentaCriteria() {
		return new CuentaDetachedCriteria(createCriteria("ORM_Cuenta"));
	}
	
	public Cliente uniqueCliente(PersistentSession session) {
		return (Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente[] listCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

