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

public class CuentaCriteria extends AbstractORMCriteria {
	public final StringExpression esActiva;
	public final IntegerExpression id_cuenta;
	
	public CuentaCriteria(Criteria criteria) {
		super(criteria);
		esActiva = new StringExpression("esActiva", this);
		id_cuenta = new IntegerExpression("id_cuenta", this);
	}
	
	public CuentaCriteria(PersistentSession session) {
		this(session.createCriteria(Cuenta.class));
	}
	
	public CuentaCriteria() throws PersistentException {
		this(orm.BDtalleraplicadoPersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createId_clienteCriteria() {
		return new ClienteCriteria(createCriteria("id_cliente"));
	}
	
	public LoginCriteria createId_loginCriteria() {
		return new LoginCriteria(createCriteria("id_login"));
	}
	
	public ConsumoCriteria createConsumoCriteria() {
		return new ConsumoCriteria(createCriteria("ORM_consumo"));
	}
	
	public Cuenta uniqueCuenta() {
		return (Cuenta) super.uniqueResult();
	}
	
	public Cuenta[] listCuenta() {
		java.util.List list = super.list();
		return (Cuenta[]) list.toArray(new Cuenta[list.size()]);
	}
}

