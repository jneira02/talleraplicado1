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

public class Cliente_historicoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_cliente_hist;
	public final StringExpression nombres;
	public final StringExpression rut;
	public final StringExpression apellido_materno;
	public final StringExpression apellido_paterno;
	public final StringExpression telefono;
	public final StringExpression email;
	public final StringExpression direccion;
	public final StringExpression fecha_modificacion;
	
	public Cliente_historicoCriteria(Criteria criteria) {
		super(criteria);
		id_cliente_hist = new IntegerExpression("id_cliente_hist", this);
		nombres = new StringExpression("nombres", this);
		rut = new StringExpression("rut", this);
		apellido_materno = new StringExpression("apellido_materno", this);
		apellido_paterno = new StringExpression("apellido_paterno", this);
		telefono = new StringExpression("telefono", this);
		email = new StringExpression("email", this);
		direccion = new StringExpression("direccion", this);
		fecha_modificacion = new StringExpression("fecha_modificacion", this);
	}
	
	public Cliente_historicoCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente_historico.class));
	}
	
	public Cliente_historicoCriteria() throws PersistentException {
		this(orm.BDtalleraplicadoPersistentManager.instance().getSession());
	}
	
	public LoginCriteria createId_loginCriteria() {
		return new LoginCriteria(createCriteria("id_login"));
	}
	
	public ClienteCriteria createId_clienteCriteria() {
		return new ClienteCriteria(createCriteria("id_cliente"));
	}
	
	public Cliente_historico uniqueCliente_historico() {
		return (Cliente_historico) super.uniqueResult();
	}
	
	public Cliente_historico[] listCliente_historico() {
		java.util.List list = super.list();
		return (Cliente_historico[]) list.toArray(new Cliente_historico[list.size()]);
	}
}

