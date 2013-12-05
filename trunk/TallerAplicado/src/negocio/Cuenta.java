package negocio;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Cuenta {
	
	public String desactivarCuenta(domain.CuentaVO oCuentaVO){
		PersistentTransaction t;

		try {

			if(oCuentaVO != null) {
				/*
				 * buscar cuenta especificando cliente y setear atributo es activa a 'n'
				 */
				t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				orm.Cliente clienteCuenta = orm.ClienteDAO.loadClienteByQuery("rut = '"+oCuentaVO.getClienteVO().getRut()+"'", null);
				orm.Cuenta lormCuenta = orm.CuentaDAO.loadCuentaByQuery("id_cliente = "+clienteCuenta.getId_cliente(), null);
				lormCuenta.setEsActiva("N");
				return "cuenta desactivada";} else {
					return "campos vacios";
				}


		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error persistencia";
		}  catch (Exception ex){
			return "credenciales invalidas";
		}
	}
	
	public String registrarCuenta(domain.ClienteVO oClienteVO){
		PersistentTransaction t;
		try {
			System.out.println("USER ADM: "+oClienteVO.getLoginVO().getAdministradorVO().getUser());
			System.out.println("TOKEN: "+oClienteVO.getLoginVO().getToken());

			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();


			orm.Cuenta lormCuenta = orm.CuentaDAO.createCuenta(); // Crear objeto persistente cuenta
			lormCuenta.setEsActiva("S");

			String consultaCliente = "rut = '"+oClienteVO.getRut()+"'";

			String logCond = "token = '"+oClienteVO.getLoginVO().getToken()+"'";

			String condLogin = "user = '"+oClienteVO.getLoginVO().getAdministradorVO().getUser()
					+"' and password = '"+oClienteVO.getLoginVO().getAdministradorVO().getPassword() +"'";

			orm.Administrador adminLogeadoORM = orm.AdministradorDAO.loadAdministradorByQuery(condLogin, null);
			orm.Login loginAdminORM = orm.LoginDAO.loadLoginByQuery(logCond, null);
			orm.Cliente lormCliente = orm.ClienteDAO.loadClienteByQuery(consultaCliente, null);

			if(loginAdminORM == null){
				System.out.println("esta NULO el LOGIN ADMIN");
			} else {
				System.out.println("NO ESTA NULO**"+oClienteVO.getRut());

			}

			loginAdminORM.setId_administrador(adminLogeadoORM);
			lormCliente.setId_login(loginAdminORM);
			lormCuenta.setId_cliente(lormCliente);
			lormCuenta.setId_login(loginAdminORM);
			orm.ClienteDAO.save(lormCliente);

			t.commit();
			return "cuenta asignada y activada";

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error persistencia";
		} catch (Exception ex){
			ex.printStackTrace();
			return "credenciales invalidas";
		}
	}
}
