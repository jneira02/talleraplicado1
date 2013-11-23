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

public class ClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_cliente;
	public final StringExpression rut;
	public final StringExpression nombres;
	public final StringExpression apellido_materno;
	public final StringExpression apellido_paterno;
	public final StringExpression telefono;
	public final StringExpression email;
	public final StringExpression direccion;
	public final StringExpression fecha_creacion;
	
	public ClienteCriteria(Criteria criteria) {
		super(criteria);
		id_cliente = new IntegerExpression("id_cliente", this);
		rut = new StringExpression("rut", this);
		nombres = new StringExpression("nombres", this);
		apellido_materno = new StringExpression("apellido_materno", this);
		apellido_paterno = new StringExpression("apellido_paterno", this);
		telefono = new StringExpression("telefono", this);
		email = new StringExpression("email", this);
		direccion = new StringExpression("direccion", this);
		fecha_creacion = new StringExpression("fecha_creacion", this);
	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(orm.BDtalleraplicadoPersistentManager.instance().getSession());
	}
	
	public LoginCriteria createId_loginCriteria() {
		return new LoginCriteria(createCriteria("id_login"));
	}
	
	public Cliente_historicoCriteria createCliente_historicoCriteria() {
		return new Cliente_historicoCriteria(createCriteria("ORM_Cliente_historico"));
	}
	
	public CuentaCriteria createCuentaCriteria() {
		return new CuentaCriteria(createCriteria("ORM_Cuenta"));
	}
	
	public Cliente uniqueCliente() {
		return (Cliente) super.uniqueResult();
	}
	
	public Cliente[] listCliente() {
		java.util.List list = super.list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

