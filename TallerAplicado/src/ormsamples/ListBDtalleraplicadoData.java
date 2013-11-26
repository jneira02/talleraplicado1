/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListBDtalleraplicadoData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Cliente...");
		orm.Cliente[] ormClientes = orm.ClienteDAO.listClienteByQuery(null, null);
		int length = Math.min(ormClientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormClientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Consumo...");
		orm.Consumo[] ormConsumos = orm.ConsumoDAO.listConsumoByQuery(null, null);
		length = Math.min(ormConsumos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormConsumos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Login...");
		orm.Login[] ormLogins = orm.LoginDAO.listLoginByQuery(null, null);
		length = Math.min(ormLogins.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormLogins[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		orm.Administrador[] ormAdministradors = orm.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(ormAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente_historico...");
		orm.Cliente_historico[] ormCliente_historicos = orm.Cliente_historicoDAO.listCliente_historicoByQuery(null, null);
		length = Math.min(ormCliente_historicos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormCliente_historicos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cuenta...");
		orm.Cuenta[] ormCuentas = orm.CuentaDAO.listCuentaByQuery(null, null);
		length = Math.min(ormCuentas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormCuentas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException  {
		System.out.println("Listing Cliente by Criteria...");
		orm.ClienteCriteria lormClienteCriteria = new orm.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormClienteCriteria.id_cliente.eq();
		lormClienteCriteria.setMaxResults(ROW_COUNT);
		orm.Cliente[] ormClientes = lormClienteCriteria.listCliente();
		int length =ormClientes== null ? 0 : Math.min(ormClientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormClientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing Consumo by Criteria...");
		orm.ConsumoCriteria lormConsumoCriteria = new orm.ConsumoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormConsumoCriteria.id_consumo.eq();
		lormConsumoCriteria.setMaxResults(ROW_COUNT);
		orm.Consumo[] ormConsumos = lormConsumoCriteria.listConsumo();
		length =ormConsumos== null ? 0 : Math.min(ormConsumos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormConsumos[i]);
		}
		System.out.println(length + " Consumo record(s) retrieved."); 
		
		System.out.println("Listing Login by Criteria...");
		orm.LoginCriteria lormLoginCriteria = new orm.LoginCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormLoginCriteria.id_login.eq();
		lormLoginCriteria.setMaxResults(ROW_COUNT);
		orm.Login[] ormLogins = lormLoginCriteria.listLogin();
		length =ormLogins== null ? 0 : Math.min(ormLogins.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormLogins[i]);
		}
		System.out.println(length + " Login record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		orm.AdministradorCriteria lormAdministradorCriteria = new orm.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormAdministradorCriteria.id_administrador.eq();
		lormAdministradorCriteria.setMaxResults(ROW_COUNT);
		orm.Administrador[] ormAdministradors = lormAdministradorCriteria.listAdministrador();
		length =ormAdministradors== null ? 0 : Math.min(ormAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Cliente_historico by Criteria...");
		orm.Cliente_historicoCriteria lormCliente_historicoCriteria = new orm.Cliente_historicoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormCliente_historicoCriteria.id_cliente_hist.eq();
		lormCliente_historicoCriteria.setMaxResults(ROW_COUNT);
		orm.Cliente_historico[] ormCliente_historicos = lormCliente_historicoCriteria.listCliente_historico();
		length =ormCliente_historicos== null ? 0 : Math.min(ormCliente_historicos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormCliente_historicos[i]);
		}
		System.out.println(length + " Cliente_historico record(s) retrieved."); 
		
		System.out.println("Listing Cuenta by Criteria...");
		orm.CuentaCriteria lormCuentaCriteria = new orm.CuentaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormCuentaCriteria.id_cuenta.eq();
		lormCuentaCriteria.setMaxResults(ROW_COUNT);
		orm.Cuenta[] ormCuentas = lormCuentaCriteria.listCuenta();
		length =ormCuentas== null ? 0 : Math.min(ormCuentas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormCuentas[i]);
		}
		System.out.println(length + " Cuenta record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListBDtalleraplicadoData listBDtalleraplicadoData = new ListBDtalleraplicadoData();
			try {
				listBDtalleraplicadoData.listTestData();
				//listBDtalleraplicadoData.listByCriteria();
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
