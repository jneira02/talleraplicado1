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

public class AdministradorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_administrador;
	public final StringExpression user;
	public final StringExpression password;
	
	public AdministradorCriteria(Criteria criteria) {
		super(criteria);
		id_administrador = new IntegerExpression("id_administrador", this);
		user = new StringExpression("user", this);
		password = new StringExpression("password", this);
	}
	
	public AdministradorCriteria(PersistentSession session) {
		this(session.createCriteria(Administrador.class));
	}
	
	public AdministradorCriteria() throws PersistentException {
		this(orm.BDtalleraplicadoPersistentManager.instance().getSession());
	}
	
	public LoginCriteria createLoginCriteria() {
		return new LoginCriteria(createCriteria("ORM_Login"));
	}
	
	public Administrador uniqueAdministrador() {
		return (Administrador) super.uniqueResult();
	}
	
	public Administrador[] listAdministrador() {
		java.util.List list = super.list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

