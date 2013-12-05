package negocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.AdministradorVO;
import domain.ClienteVO;
import domain.ConsumoVO;
import domain.CuentaVO;
import domain.LoginVO;

public class Consumo {
	
	public String modificarConsumo(domain.ConsumoVO oConsumoVO){

		PersistentTransaction t;
		try {

			if(oConsumoVO != null){

				t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();

				String consultaCliente = "rut = '"+oConsumoVO.getCuentaVO().getClienteVO().getRut()+"'";

				String logCond = "token = '"+oConsumoVO.getCuentaVO().getClienteVO().getLoginVO().getToken()+"' and sesionActiva = 'S'";

				String condLogin = "user = '"+oConsumoVO.getCuentaVO().getClienteVO().getLoginVO().getAdministradorVO().getUser()
						+"' and password = '"+oConsumoVO.getCuentaVO().getClienteVO().getLoginVO().getAdministradorVO().getPassword() +"'";

				orm.Administrador adminLogeadoORM = orm.AdministradorDAO.loadAdministradorByQuery(condLogin, null);
				orm.Login loginAdminORM = orm.LoginDAO.loadLoginByQuery(logCond, null);
				orm.Cliente lormCliente = orm.ClienteDAO.loadClienteByQuery(consultaCliente, null);
				orm.Cuenta lormCuenta = orm.CuentaDAO.loadCuentaByQuery("id_cliente = "+lormCliente.getId_cliente(), null);
				orm.Consumo lormConsumo = orm.ConsumoDAO.loadConsumoByQuery("id_cuenta = "+lormCuenta.getId_cuenta(), null);

				lormConsumo.setTipo_servicio(oConsumoVO.getTipo_servicio());
				lormConsumo.setUnidad_servicio(oConsumoVO.getUnidad_servicio());
				lormConsumo.setMonto_unidad(oConsumoVO.getMonto_unidad());
				lormConsumo.setCantidad_unidades(oConsumoVO.getCantidad_unidades());
				lormConsumo.setMonto_total(oConsumoVO.getMonto_total());
				lormConsumo.setEsta_pagado(oConsumoVO.getEsta_pagado());
				lormConsumo.setFecha_vencimiento(oConsumoVO.getFecha_vencimiento());
				/*System.out.println("pecebre********"+adminLogeadoORM.getUser()+"\n"+loginAdminORM.getToken()+"\n"
					+ lormCliente.getNombres()+"\n"+lormCuenta.getEsActiva()+"\n FIN********");*/

				loginAdminORM.setId_administrador(adminLogeadoORM);
				lormCliente.setId_login(loginAdminORM);
				lormCuenta.setId_cliente(lormCliente);
				lormCuenta.setId_login(loginAdminORM);
				lormConsumo.setId_cuenta(lormCuenta);
				lormConsumo.setId_cliente(lormCliente.getId_cliente());

				//orm.ConsumoDAO.save(lormConsumo);
				t.commit();

				return "consumo modificado";} else {
					return "campos vacios";
				}
			//lormConsumo.setId_cuenta(value);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Exception ex){
			return "credenciales invalidas";
		}
		return null;
	}
	
	public List<domain.ConsumoVO> mostrarClientesConsumos(domain.ClienteVO oClienteVO){



		List<domain.ConsumoVO> consumosClientes = new ArrayList<domain.ConsumoVO>();

		PersistentTransaction t;
		try {
			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();		

			orm.Cliente clientes = orm.ClienteDAO.loadClienteByQuery("rut = '"+oClienteVO.getRut()+"'", null);
			orm.Cuenta cuentaConsultada = orm.CuentaDAO.loadCuentaByQuery("id_cliente = '"+clientes.getId_cliente()+"'", null);
			orm.Consumo[] consumosClienteORM = orm.ConsumoDAO.listConsumoByQuery("id_cliente = '"+clientes.getId_cliente()+"'", null);

			/*if(cuentaConsultada == null || consumosClienteORM.length == 0){
				ConsumoVO consumoDefault = new ConsumoVO("Cliente sin cuenta asignada o sin consumos!", null, 0, 0, 0, null, null, null);
				List<domain.ConsumoVO> consumoDefaultLIST = new ArrayList<domain.ConsumoVO>();
				consumoDefaultLIST.add(consumoDefault);
				return consumoDefaultLIST;

			}*/

			domain.LoginVO LoginEnOrm = new LoginVO(clientes.getId_login().getToken(), clientes.getId_login().getFecha_logeo(),
					new AdministradorVO(clientes.getId_login().getId_administrador().getUser(),
							clientes.getId_login().getId_administrador().getPassword()), clientes.getId_login().getFecha_logeo(), "");

			ClienteVO clienteEnOrm = new ClienteVO(clientes.getRut(), clientes.getNombres(),
					clientes.getApellido_materno(), clientes.getApellido_paterno(), clientes.getTelefono(),
					clientes.getEmail(), clientes.getDireccion(), clientes.getFecha_creacion(),
					LoginEnOrm);

			if(cuentaConsultada == null){
				return null;
			}
			domain.CuentaVO CuentaEnOrm = new CuentaVO(cuentaConsultada.getEsActiva(),clienteEnOrm,LoginEnOrm);



			for(int i=0;i<consumosClienteORM.length;i++){
				/*
				 * Ya paso la epoca donde el codigo no funciona a la primera :D
				 */

				/*
				 * Guarda en la lista consumos de clientes con todos los datos de cuentas,
				 * clientes, logins y administrador (mega-objeto)
				 */
				consumosClientes.add(new ConsumoVO(
						consumosClienteORM[i].getTipo_servicio(),
						consumosClienteORM[i].getUnidad_servicio(),
						consumosClienteORM[i].getMonto_unidad(),
						consumosClienteORM[i].getCantidad_unidades(),
						consumosClienteORM[i].getMonto_total(),
						consumosClienteORM[i].getEsta_pagado(),
						consumosClienteORM[i].getFecha_vencimiento(),
						CuentaEnOrm
						));


			}

			return consumosClientes;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 

	}
	
	public String registrarConsumo(domain.ConsumoVO oConsumoVO){

		// TODO: Averiguar como unir foranea de cuentas

		PersistentTransaction t;
		try {
			if(oConsumoVO != null) {
				t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				orm.Consumo lormConsumo = orm.ConsumoDAO.createConsumo();
				/*
				 * Crea el objeto consumo con los parametros especificados
				 */
				lormConsumo.setTipo_servicio(oConsumoVO.getTipo_servicio());
				lormConsumo.setUnidad_servicio(oConsumoVO.getUnidad_servicio());
				lormConsumo.setMonto_unidad(oConsumoVO.getMonto_unidad());
				lormConsumo.setCantidad_unidades(oConsumoVO.getCantidad_unidades());
				lormConsumo.setMonto_total(oConsumoVO.getMonto_total());
				lormConsumo.setEsta_pagado(oConsumoVO.getEsta_pagado());
				lormConsumo.setFecha_vencimiento(oConsumoVO.getFecha_vencimiento());

				String consultaCliente = "rut = '"+oConsumoVO.getCuentaVO().getClienteVO().getRut()+"'";

				String logCond = "token = '"+oConsumoVO.getCuentaVO().getClienteVO().getLoginVO().getToken()+"'";

				String condLogin = "user = '"+oConsumoVO.getCuentaVO().getClienteVO().getLoginVO().getAdministradorVO().getUser()
						+"' and password = '"+oConsumoVO.getCuentaVO().getClienteVO().getLoginVO().getAdministradorVO().getPassword() +"'";

				orm.Administrador adminLogeadoORM = orm.AdministradorDAO.loadAdministradorByQuery(condLogin, null);
				orm.Login loginAdminORM = orm.LoginDAO.loadLoginByQuery(logCond, null);
				orm.Cliente lormCliente = orm.ClienteDAO.loadClienteByQuery(consultaCliente, null);
				orm.Cuenta lormCuenta = orm.CuentaDAO.loadCuentaByQuery("id_cliente = "+lormCliente.getId_cliente(), null);


				/*System.out.println("pecebre********"+adminLogeadoORM.getUser()+"\n"+loginAdminORM.getToken()+"\n"
					+ lormCliente.getNombres()+"\n"+lormCuenta.getEsActiva()+"\n FIN********");*/

				loginAdminORM.setId_administrador(adminLogeadoORM);
				lormCliente.setId_login(loginAdminORM);
				lormCuenta.setId_cliente(lormCliente);
				lormCuenta.setId_login(loginAdminORM);
				lormConsumo.setId_cuenta(lormCuenta);
				lormConsumo.setId_cliente(lormCliente.getId_cliente());

				orm.ConsumoDAO.save(lormConsumo);

				t.commit();

				return "consumo asociado a cliente"; } else {
					return "campos vacios";
				}
			//lormConsumo.setId_cuenta(value);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Exception ex){
			ex.printStackTrace();
			return "credenciales invalidas";

		}


		return null;
	}
}
