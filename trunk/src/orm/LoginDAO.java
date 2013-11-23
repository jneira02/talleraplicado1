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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class LoginDAO {
	public static Login loadLoginByORMID(int id_login) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadLoginByORMID(session, id_login);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login getLoginByORMID(int id_login) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return getLoginByORMID(session, id_login);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByORMID(int id_login, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadLoginByORMID(session, id_login, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login getLoginByORMID(int id_login, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return getLoginByORMID(session, id_login, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByORMID(PersistentSession session, int id_login) throws PersistentException {
		try {
			return (Login) session.load(orm.Login.class, new Integer(id_login));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login getLoginByORMID(PersistentSession session, int id_login) throws PersistentException {
		try {
			return (Login) session.get(orm.Login.class, new Integer(id_login));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByORMID(PersistentSession session, int id_login, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Login) session.load(orm.Login.class, new Integer(id_login), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login getLoginByORMID(PersistentSession session, int id_login, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Login) session.get(orm.Login.class, new Integer(id_login), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return queryLogin(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return queryLogin(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login[] listLoginByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return listLoginByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login[] listLoginByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return listLoginByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Login as Login");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Login as Login");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login[] listLoginByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLogin(session, condition, orderBy);
			return (Login[]) list.toArray(new Login[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login[] listLoginByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLogin(session, condition, orderBy, lockMode);
			return (Login[]) list.toArray(new Login[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadLoginByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadLoginByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Login[] logins = listLoginByQuery(session, condition, orderBy);
		if (logins != null && logins.length > 0)
			return logins[0];
		else
			return null;
	}
	
	public static Login loadLoginByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Login[] logins = listLoginByQuery(session, condition, orderBy, lockMode);
		if (logins != null && logins.length > 0)
			return logins[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLoginByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return iterateLoginByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLoginByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return iterateLoginByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLoginByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Login as Login");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLoginByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Login as Login");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login createLogin() {
		return new orm.Login();
	}
	
	public static boolean save(orm.Login login) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().saveObject(login);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Login login) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().deleteObject(login);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Login login)throws PersistentException {
		try {
			if(login.getId_administrador() != null) {
				login.getId_administrador().login.remove(login);
			}
			
			orm.Cliente[] lClientes = login.cliente.toArray();
			for(int i = 0; i < lClientes.length; i++) {
				lClientes[i].setId_login(null);
			}
			orm.Cliente_historico[] lCliente_historicos = login.cliente_historico.toArray();
			for(int i = 0; i < lCliente_historicos.length; i++) {
				lCliente_historicos[i].setId_login(null);
			}
			orm.Cuenta[] lCuentas = login.cuenta.toArray();
			for(int i = 0; i < lCuentas.length; i++) {
				lCuentas[i].setId_login(null);
			}
			return delete(login);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Login login, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(login.getId_administrador() != null) {
				login.getId_administrador().login.remove(login);
			}
			
			orm.Cliente[] lClientes = login.cliente.toArray();
			for(int i = 0; i < lClientes.length; i++) {
				lClientes[i].setId_login(null);
			}
			orm.Cliente_historico[] lCliente_historicos = login.cliente_historico.toArray();
			for(int i = 0; i < lCliente_historicos.length; i++) {
				lCliente_historicos[i].setId_login(null);
			}
			orm.Cuenta[] lCuentas = login.cuenta.toArray();
			for(int i = 0; i < lCuentas.length; i++) {
				lCuentas[i].setId_login(null);
			}
			try {
				session.delete(login);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Login login) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().getSession().refresh(login);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Login login) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().getSession().evict(login);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login loadLoginByCriteria(LoginCriteria loginCriteria) {
		Login[] logins = listLoginByCriteria(loginCriteria);
		if(logins == null || logins.length == 0) {
			return null;
		}
		return logins[0];
	}
	
	public static Login[] listLoginByCriteria(LoginCriteria loginCriteria) {
		return loginCriteria.listLogin();
	}
}
