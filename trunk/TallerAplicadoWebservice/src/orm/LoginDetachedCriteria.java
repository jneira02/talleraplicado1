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

public class LoginDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_login;
	public final StringExpression token;
	public final StringExpression fecha_logeo;
	public final StringExpression fecha_fin;
	public final StringExpression sesionActiva;
	
	public LoginDetachedCriteria() {
		super(orm.Login.class, orm.LoginCriteria.class);
		id_login = new IntegerExpression("id_login", this.getDetachedCriteria());
		token = new StringExpression("token", this.getDetachedCriteria());
		fecha_logeo = new StringExpression("fecha_logeo", this.getDetachedCriteria());
		fecha_fin = new StringExpression("fecha_fin", this.getDetachedCriteria());
		sesionActiva = new StringExpression("sesionActiva", this.getDetachedCriteria());
	}
	
	public LoginDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.LoginCriteria.class);
		id_login = new IntegerExpression("id_login", this.getDetachedCriteria());
		token = new StringExpression("token", this.getDetachedCriteria());
		fecha_logeo = new StringExpression("fecha_logeo", this.getDetachedCriteria());
		fecha_fin = new StringExpression("fecha_fin", this.getDetachedCriteria());
		sesionActiva = new StringExpression("sesionActiva", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria createId_administradorCriteria() {
		return new AdministradorDetachedCriteria(createCriteria("id_administrador"));
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("ORM_Cliente"));
	}
	
	public Cliente_historicoDetachedCriteria createCliente_historicoCriteria() {
		return new Cliente_historicoDetachedCriteria(createCriteria("ORM_Cliente_historico"));
	}
	
	public CuentaDetachedCriteria createCuentaCriteria() {
		return new CuentaDetachedCriteria(createCriteria("ORM_Cuenta"));
	}
	
	public Login uniqueLogin(PersistentSession session) {
		return (Login) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Login[] listLogin(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Login[]) list.toArray(new Login[list.size()]);
	}
}

