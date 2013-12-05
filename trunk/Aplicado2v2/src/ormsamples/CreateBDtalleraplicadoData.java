/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateBDtalleraplicadoData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Cliente lormCliente = orm.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cuenta, cliente_historico, id_login, rut
			orm.ClienteDAO.save(lormCliente);
			orm.Consumo lormConsumo = orm.ConsumoDAO.createConsumo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : id_cuenta, id_cliente, fecha_vencimiento
			orm.ConsumoDAO.save(lormConsumo);
			orm.Login lormLogin = orm.LoginDAO.createLogin();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cuenta, cliente_historico, cliente, sesionActiva, id_administrador
			orm.LoginDAO.save(lormLogin);
			orm.Administrador lormAdministrador = orm.AdministradorDAO.createAdministrador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : login, password, user
			orm.AdministradorDAO.save(lormAdministrador);
			orm.Cliente_historico lormCliente_historico = orm.Cliente_historicoDAO.createCliente_historico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : id_cliente, id_login
			orm.Cliente_historicoDAO.save(lormCliente_historico);
			orm.Cuenta lormCuenta = orm.CuentaDAO.createCuenta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : consumo, id_login, id_cliente, esActiva
			orm.CuentaDAO.save(lormCuenta);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateBDtalleraplicadoData createBDtalleraplicadoData = new CreateBDtalleraplicadoData();
			try {
				createBDtalleraplicadoData.createTestData();
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
