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

public class CuentaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression esActiva;
	public final IntegerExpression id_cuenta;
	
	public CuentaDetachedCriteria() {
		super(orm.Cuenta.class, orm.CuentaCriteria.class);
		esActiva = new StringExpression("esActiva", this.getDetachedCriteria());
		id_cuenta = new IntegerExpression("id_cuenta", this.getDetachedCriteria());
	}
	
	public CuentaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.CuentaCriteria.class);
		esActiva = new StringExpression("esActiva", this.getDetachedCriteria());
		id_cuenta = new IntegerExpression("id_cuenta", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createId_clienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("id_cliente"));
	}
	
	public LoginDetachedCriteria createId_loginCriteria() {
		return new LoginDetachedCriteria(createCriteria("id_login"));
	}
	
	public ConsumoDetachedCriteria createConsumoCriteria() {
		return new ConsumoDetachedCriteria(createCriteria("ORM_Consumo"));
	}
	
	public Cuenta uniqueCuenta(PersistentSession session) {
		return (Cuenta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cuenta[] listCuenta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cuenta[]) list.toArray(new Cuenta[list.size()]);
	}
}

