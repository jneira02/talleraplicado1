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

public class LoginCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_login;
	public final StringExpression token;
	public final StringExpression fecha_logeo;
	public final StringExpression fecha_fin;
	public final StringExpression sesionActiva;
	
	public LoginCriteria(Criteria criteria) {
		super(criteria);
		id_login = new IntegerExpression("id_login", this);
		token = new StringExpression("token", this);
		fecha_logeo = new StringExpression("fecha_logeo", this);
		fecha_fin = new StringExpression("fecha_fin", this);
		sesionActiva = new StringExpression("sesionActiva", this);
	}
	
	public LoginCriteria(PersistentSession session) {
		this(session.createCriteria(Login.class));
	}
	
	public LoginCriteria() throws PersistentException {
		this(orm.BDtalleraplicadoPersistentManager.instance().getSession());
	}
	
	public AdministradorCriteria createId_administradorCriteria() {
		return new AdministradorCriteria(createCriteria("id_administrador"));
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("ORM_Cliente"));
	}
	
	public Cliente_historicoCriteria createCliente_historicoCriteria() {
		return new Cliente_historicoCriteria(createCriteria("ORM_Cliente_historico"));
	}
	
	public CuentaCriteria createCuentaCriteria() {
		return new CuentaCriteria(createCriteria("ORM_Cuenta"));
	}
	
	public Login uniqueLogin() {
		return (Login) super.uniqueResult();
	}
	
	public Login[] listLogin() {
		java.util.List list = super.list();
		return (Login[]) list.toArray(new Login[list.size()]);
	}
}

