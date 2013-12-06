package negocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.AdministradorVO;
import domain.ClienteVO;
import domain.Cliente_historicoVO;
import domain.LoginVO;

public class Cliente {
	
	public List<domain.Cliente_historicoVO> mostrarClientesHistoricos(domain.ClienteVO oClienteVO){
		List<domain.Cliente_historicoVO> clientesModificados = new ArrayList<domain.Cliente_historicoVO>();

		PersistentTransaction t;
		try {
			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();		

			orm.Cliente clienteConsultado = orm.ClienteDAO.loadClienteByQuery("rut = '"+oClienteVO.getRut()+"'", null);
			orm.Cliente_historico[] clientes = orm.Cliente_historicoDAO.listCliente_historicoByQuery("id_cliente = '"+clienteConsultado.getId_cliente()+"'", null);

			for(int i=0;i<clientes.length;i++){
				domain.LoginVO LoginEnOrm = new LoginVO(clientes[i].getId_login().getToken(), clientes[i].getId_login().getFecha_logeo(),
						new AdministradorVO(clientes[i].getId_login().getId_administrador().getUser(),
								clientes[i].getId_login().getId_administrador().getPassword()), clientes[i].getId_login().getFecha_logeo(), "");

				clientesModificados.add(new Cliente_historicoVO(clientes[i].getRut(), clientes[i].getNombres(),
						clientes[i].getApellido_materno(), clientes[i].getApellido_paterno(), clientes[i].getTelefono(),
						clientes[i].getEmail(), clientes[i].getDireccion(), clientes[i].getFecha_modificacion(),
						LoginEnOrm, null));
			}
			return clientesModificados;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 

	}
	
	public List<domain.ClienteVO> mostrarClientes(domain.ClienteVO oClienteVO){
		List<domain.ClienteVO> clientesIngresados = new ArrayList<domain.ClienteVO>();


		PersistentTransaction t;
		try {
			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();

			String condicion = "";
			/*
			 * El parametro ClienteVO se usa para filtrar, si viene nulo se muestran todos los clientes ingresados
			 */
			if(oClienteVO != null) {

				if(oClienteVO.getNombres()!=""){
					condicion += "nombres like '%"+oClienteVO.getNombres()+"%' and ";
				} if(oClienteVO.getApellido_paterno()!=null){
					condicion += "apellido_paterno like '%"+oClienteVO.getApellido_paterno()+"%' and ";
				} if(oClienteVO.getApellido_materno()!=null){
					condicion += "apellido_materno like '%"+oClienteVO.getApellido_materno()+"%' and ";
				} if(oClienteVO.getRut()!=null){
					condicion += "rut like '%"+oClienteVO.getRut()+"%' and ";
				} if(oClienteVO.getTelefono()!=null){
					condicion += "telefono like '%"+oClienteVO.getTelefono()+"%' and ";
				}  if(oClienteVO.getEmail()!=null){
					condicion += "email like '%"+oClienteVO.getEmail()+"%' and ";
				}  if(oClienteVO.getDireccion()!=null){
					condicion += "direccion = '"+oClienteVO.getDireccion()+"'";
					condicion +=" and ";
				}  if(condicion!=""){
					condicion=condicion.substring(0, condicion.length()-5);
				}}

			if(condicion == ""){
				condicion = null;
			}

			System.out.println("CONDICION: "+condicion);

			orm.Cliente[] clientes = orm.ClienteDAO.listClienteByQuery(condicion, null);
			/*
			 * Se compone el cliente para que tenga todos sus atributos correspondientes
			 */
			for(int i=0;i<clientes.length;i++){
				domain.LoginVO LoginEnOrm = new LoginVO(clientes[i].getId_login().getToken(), clientes[i].getId_login().getFecha_logeo(),
						new AdministradorVO(clientes[i].getId_login().getId_administrador().getUser(),
								clientes[i].getId_login().getId_administrador().getPassword()), clientes[i].getId_login().getFecha_logeo(), "");

				clientesIngresados.add(new ClienteVO(clientes[i].getRut(), clientes[i].getNombres(),
						clientes[i].getApellido_materno(), clientes[i].getApellido_paterno(), clientes[i].getTelefono(),
						clientes[i].getEmail(), clientes[i].getDireccion(), clientes[i].getFecha_creacion(),
						LoginEnOrm));
			}
			return clientesIngresados;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 

	}
	
	public String modificarCliente(domain.ClienteVO oClienteVOAntiguo, domain.ClienteVO oClienteVONuevo){
		PersistentTransaction t;
		try {



			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
			/*
			 * Buscar cliente antiguo para modificarlo
			 */
			String consultaCliente = "rut = '"+oClienteVOAntiguo.getRut()+"'";
			orm.Cliente lormCliente = orm.ClienteDAO.loadClienteByQuery(consultaCliente, null);

			// Primero comprobar que la sesion actual esta activa, o que el token sea valido
			// comprobar();
			// Luego comprobar si el cliente o login vienen vacíos


			/*
			 * Modificar cliente buscado en la BD
			 */

			lormCliente.setRut(oClienteVONuevo.getRut());
			lormCliente.setNombres(oClienteVONuevo.getNombres());
			lormCliente.setApellido_materno(oClienteVONuevo.getApellido_materno());
			lormCliente.setApellido_paterno(oClienteVONuevo.getApellido_paterno());
			lormCliente.setTelefono(oClienteVONuevo.getTelefono());
			lormCliente.setEmail(oClienteVONuevo.getEmail());
			lormCliente.setDireccion(oClienteVONuevo.getDireccion());

			orm.Cliente_historico lormClienteHist = orm.Cliente_historicoDAO.createCliente_historico();

			lormClienteHist.setRut(oClienteVOAntiguo.getRut());
			lormClienteHist.setNombres(oClienteVOAntiguo.getNombres());
			lormClienteHist.setApellido_materno(oClienteVOAntiguo.getApellido_materno());
			lormClienteHist.setApellido_paterno(oClienteVOAntiguo.getApellido_paterno());
			lormClienteHist.setTelefono(oClienteVOAntiguo.getTelefono());
			lormClienteHist.setEmail(oClienteVOAntiguo.getEmail());
			lormClienteHist.setDireccion(oClienteVOAntiguo.getDireccion());
			lormClienteHist.setFecha_modificacion(utilitarios.Utilitario.fechaActual());



			/*String userTemp = "admin";
		String passTemp = "admin";

		String token = "HEBANXSXHMLNTFUXEDPRQGVEDBMCIOHJ";
			 */

			/*	String condLogin = "user = '"+oClienteVOAntiguo.getLoginVO().getAdministradorVO().getUser()  
					+"' and password = '"+oClienteVOAntiguo.getLoginVO().getAdministradorVO().getPassword() +"'";*/

			String logCond = "token = '"+oClienteVOAntiguo.getLoginVO().getToken() /*token*/+"' and sesionActiva = 'S'";

			orm.Login loginAdminORM = orm.LoginDAO.loadLoginByQuery(logCond, null);
			//orm.Administrador adminLogeadoORM = orm.AdministradorDAO.loadAdministradorByQuery(condLogin, null);

			//loginAdminORM.setId_administrador(adminLogeadoORM);
			lormClienteHist.setId_login(loginAdminORM);
			lormClienteHist.setId_cliente(lormCliente);
			orm.Cliente_historicoDAO.save(lormClienteHist);

			/*
			 * Guarda cliente con datos de login y admin
			 */
			//orm.ClienteDAO.save(lormCliente);
			t.commit();
			return "cliente modificado";
		} catch (PersistentException e) {
			e.printStackTrace();
			return "error persistencia";

		}  catch (Exception ex){
			ex.printStackTrace();
			return "credenciales invalidas";
		}

	}
	/**
	 * 
	 * @param oClienteVO
	 * @return
	 */

	public String registrarCliente(domain.ClienteVO oClienteVO){
		if(oClienteVO!=null || oClienteVO.getRut()!=" " || oClienteVO.getNombres()!=" " || 
		oClienteVO.getApellido_materno()!=" "|| oClienteVO.getApellido_paterno()!=" " ||
		oClienteVO.getTelefono()!="" || oClienteVO.getEmail()!=" " || oClienteVO.getDireccion()!=" "){
			
			PersistentTransaction t;
	        try {
	                t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
	                orm.Cliente lormCliente = orm.ClienteDAO.createCliente();
	                lormCliente.setRut(oClienteVO.getRut());
	                lormCliente.setNombres(oClienteVO.getNombres());
	                lormCliente.setApellido_materno(oClienteVO.getApellido_materno());
	                lormCliente.setApellido_paterno(oClienteVO.getApellido_paterno());
	                lormCliente.setTelefono(oClienteVO.getTelefono());
	                lormCliente.setEmail(oClienteVO.getEmail());
	                lormCliente.setDireccion(oClienteVO.getDireccion());
	                lormCliente.setFecha_creacion(utilitarios.Utilitario.fechaActual());

	                String logCond = "token = '"+oClienteVO.getLoginVO().getToken()+"'";

	                orm.Login loginAdminORM = orm.LoginDAO.loadLoginByQuery(logCond, null);

	                lormCliente.setId_login(loginAdminORM);

	                orm.ClienteDAO.save(lormCliente);


	                t.commit();
	                return "cliente ingresado"; 
	        } catch (PersistentException e) {
	            e.printStackTrace();
	            return "error persistencia";

	        }  catch (Exception ex){
	            ex.printStackTrace();
	            return "credenciales invalidas";
	        }
	        
		}else return "Campos Nulos";
	
	}

}
