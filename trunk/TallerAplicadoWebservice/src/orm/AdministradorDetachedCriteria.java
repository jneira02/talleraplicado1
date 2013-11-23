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

public class AdministradorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_administrador;
	public final StringExpression user;
	public final StringExpression password;
	
	public AdministradorDetachedCriteria() {
		super(orm.Administrador.class, orm.AdministradorCriteria.class);
		id_administrador = new IntegerExpression("id_administrador", this.getDetachedCriteria());
		user = new StringExpression("user", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.AdministradorCriteria.class);
		id_administrador = new IntegerExpression("id_administrador", this.getDetachedCriteria());
		user = new StringExpression("user", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public LoginDetachedCriteria createLoginCriteria() {
		return new LoginDetachedCriteria(createCriteria("ORM_Login"));
	}
	
	public Administrador uniqueAdministrador(PersistentSession session) {
		return (Administrador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Administrador[] listAdministrador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

