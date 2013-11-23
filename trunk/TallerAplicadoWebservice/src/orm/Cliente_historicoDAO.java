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

public class Cliente_historicoDAO {
	public static Cliente_historico loadCliente_historicoByORMID(int id_cliente_hist) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadCliente_historicoByORMID(session, id_cliente_hist);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico getCliente_historicoByORMID(int id_cliente_hist) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return getCliente_historicoByORMID(session, id_cliente_hist);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByORMID(int id_cliente_hist, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadCliente_historicoByORMID(session, id_cliente_hist, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico getCliente_historicoByORMID(int id_cliente_hist, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return getCliente_historicoByORMID(session, id_cliente_hist, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByORMID(PersistentSession session, int id_cliente_hist) throws PersistentException {
		try {
			return (Cliente_historico) session.load(orm.Cliente_historico.class, new Integer(id_cliente_hist));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico getCliente_historicoByORMID(PersistentSession session, int id_cliente_hist) throws PersistentException {
		try {
			return (Cliente_historico) session.get(orm.Cliente_historico.class, new Integer(id_cliente_hist));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByORMID(PersistentSession session, int id_cliente_hist, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Cliente_historico) session.load(orm.Cliente_historico.class, new Integer(id_cliente_hist), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico getCliente_historicoByORMID(PersistentSession session, int id_cliente_hist, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Cliente_historico) session.get(orm.Cliente_historico.class, new Integer(id_cliente_hist), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCliente_historico(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return queryCliente_historico(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCliente_historico(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return queryCliente_historico(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico[] listCliente_historicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return listCliente_historicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico[] listCliente_historicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return listCliente_historicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCliente_historico(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Cliente_historico as Cliente_historico");
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
	
	public static List queryCliente_historico(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Cliente_historico as Cliente_historico");
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
	
	public static Cliente_historico[] listCliente_historicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCliente_historico(session, condition, orderBy);
			return (Cliente_historico[]) list.toArray(new Cliente_historico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico[] listCliente_historicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCliente_historico(session, condition, orderBy, lockMode);
			return (Cliente_historico[]) list.toArray(new Cliente_historico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadCliente_historicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return loadCliente_historicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Cliente_historico[] cliente_historicos = listCliente_historicoByQuery(session, condition, orderBy);
		if (cliente_historicos != null && cliente_historicos.length > 0)
			return cliente_historicos[0];
		else
			return null;
	}
	
	public static Cliente_historico loadCliente_historicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Cliente_historico[] cliente_historicos = listCliente_historicoByQuery(session, condition, orderBy, lockMode);
		if (cliente_historicos != null && cliente_historicos.length > 0)
			return cliente_historicos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCliente_historicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return iterateCliente_historicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCliente_historicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.BDtalleraplicadoPersistentManager.instance().getSession();
			return iterateCliente_historicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCliente_historicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Cliente_historico as Cliente_historico");
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
	
	public static java.util.Iterator iterateCliente_historicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Cliente_historico as Cliente_historico");
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
	
	public static Cliente_historico createCliente_historico() {
		return new orm.Cliente_historico();
	}
	
	public static boolean save(orm.Cliente_historico cliente_historico) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().saveObject(cliente_historico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Cliente_historico cliente_historico) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().deleteObject(cliente_historico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Cliente_historico cliente_historico)throws PersistentException {
		try {
			if(cliente_historico.getId_login() != null) {
				cliente_historico.getId_login().cliente_historico.remove(cliente_historico);
			}
			
			if(cliente_historico.getId_cliente() != null) {
				cliente_historico.getId_cliente().cliente_historico.remove(cliente_historico);
			}
			
			return delete(cliente_historico);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Cliente_historico cliente_historico, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(cliente_historico.getId_login() != null) {
				cliente_historico.getId_login().cliente_historico.remove(cliente_historico);
			}
			
			if(cliente_historico.getId_cliente() != null) {
				cliente_historico.getId_cliente().cliente_historico.remove(cliente_historico);
			}
			
			try {
				session.delete(cliente_historico);
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
	
	public static boolean refresh(orm.Cliente_historico cliente_historico) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().getSession().refresh(cliente_historico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Cliente_historico cliente_historico) throws PersistentException {
		try {
			orm.BDtalleraplicadoPersistentManager.instance().getSession().evict(cliente_historico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cliente_historico loadCliente_historicoByCriteria(Cliente_historicoCriteria cliente_historicoCriteria) {
		Cliente_historico[] cliente_historicos = listCliente_historicoByCriteria(cliente_historicoCriteria);
		if(cliente_historicos == null || cliente_historicos.length == 0) {
			return null;
		}
		return cliente_historicos[0];
	}
	
	public static Cliente_historico[] listCliente_historicoByCriteria(Cliente_historicoCriteria cliente_historicoCriteria) {
		return cliente_historicoCriteria.listCliente_historico();
	}
}
