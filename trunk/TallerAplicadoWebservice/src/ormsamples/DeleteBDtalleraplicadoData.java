/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteBDtalleraplicadoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Cliente lormCliente = orm.ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			orm.ClienteDAO.delete(lormCliente);
			orm.Consumo lormConsumo = orm.ConsumoDAO.loadConsumoByQuery(null, null);
			// Delete the persistent object
			orm.ConsumoDAO.delete(lormConsumo);
			orm.Login lormLogin = orm.LoginDAO.loadLoginByQuery(null, null);
			// Delete the persistent object
			orm.LoginDAO.delete(lormLogin);
			orm.Administrador lormAdministrador = orm.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			orm.AdministradorDAO.delete(lormAdministrador);
			orm.Cliente_historico lormCliente_historico = orm.Cliente_historicoDAO.loadCliente_historicoByQuery(null, null);
			// Delete the persistent object
			orm.Cliente_historicoDAO.delete(lormCliente_historico);
			orm.Cuenta lormCuenta = orm.CuentaDAO.loadCuentaByQuery(null, null);
			// Delete the persistent object
			orm.CuentaDAO.delete(lormCuenta);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteBDtalleraplicadoData deleteBDtalleraplicadoData = new DeleteBDtalleraplicadoData();
			try {
				deleteBDtalleraplicadoData.deleteTestData();
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
