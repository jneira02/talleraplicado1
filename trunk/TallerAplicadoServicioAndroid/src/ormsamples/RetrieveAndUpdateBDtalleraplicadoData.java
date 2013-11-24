/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateBDtalleraplicadoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Cliente lormCliente = orm.ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			orm.ClienteDAO.save(lormCliente);
			orm.Consumo lormConsumo = orm.ConsumoDAO.loadConsumoByQuery(null, null);
			// Update the properties of the persistent object
			orm.ConsumoDAO.save(lormConsumo);
			orm.Login lormLogin = orm.LoginDAO.loadLoginByQuery(null, null);
			// Update the properties of the persistent object
			orm.LoginDAO.save(lormLogin);
			orm.Administrador lormAdministrador = orm.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			orm.AdministradorDAO.save(lormAdministrador);
			orm.Cliente_historico lormCliente_historico = orm.Cliente_historicoDAO.loadCliente_historicoByQuery(null, null);
			// Update the properties of the persistent object
			orm.Cliente_historicoDAO.save(lormCliente_historico);
			orm.Cuenta lormCuenta = orm.CuentaDAO.loadCuentaByQuery(null, null);
			// Update the properties of the persistent object
			orm.CuentaDAO.save(lormCuenta);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Cliente by ClienteCriteria");
		orm.ClienteCriteria lormClienteCriteria = new orm.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormClienteCriteria.id_cliente.eq();
		System.out.println(lormClienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Consumo by ConsumoCriteria");
		orm.ConsumoCriteria lormConsumoCriteria = new orm.ConsumoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormConsumoCriteria.id_consumo.eq();
		System.out.println(lormConsumoCriteria.uniqueConsumo());
		
		System.out.println("Retrieving Login by LoginCriteria");
		orm.LoginCriteria lormLoginCriteria = new orm.LoginCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormLoginCriteria.id_login.eq();
		System.out.println(lormLoginCriteria.uniqueLogin());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		orm.AdministradorCriteria lormAdministradorCriteria = new orm.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormAdministradorCriteria.id_administrador.eq();
		System.out.println(lormAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Cliente_historico by Cliente_historicoCriteria");
		orm.Cliente_historicoCriteria lormCliente_historicoCriteria = new orm.Cliente_historicoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormCliente_historicoCriteria.id_cliente_hist.eq();
		System.out.println(lormCliente_historicoCriteria.uniqueCliente_historico());
		
		System.out.println("Retrieving Cuenta by CuentaCriteria");
		orm.CuentaCriteria lormCuentaCriteria = new orm.CuentaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormCuentaCriteria.id_cuenta.eq();
		System.out.println(lormCuentaCriteria.uniqueCuenta());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateBDtalleraplicadoData retrieveAndUpdateBDtalleraplicadoData = new RetrieveAndUpdateBDtalleraplicadoData();
			try {
				retrieveAndUpdateBDtalleraplicadoData.retrieveAndUpdateTestData();
				//retrieveAndUpdateBDtalleraplicadoData.retrieveByCriteria();
			}
			finally {
				orm.BDtalleraplicadoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
