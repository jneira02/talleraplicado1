/*
 * 
 */
package webservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument.WhiteSpace.Value;
import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.transform.ResultTransformer;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import orm.Cliente_historico;
import orm.Cliente_historicoCriteria;
import domain.AdministradorVO;
import domain.ClienteVO;
import domain.Cliente_historicoVO;
import domain.ConsumoVO;
import domain.CuentaVO;
import domain.LoginVO;

// TODO: Auto-generated Javadoc

/**
 * The Class ServicioWeb.
 */

/*
 * Autor: Mauricio Cuevas
 */

public class ServicioWeb {
	
	
	/**
	 * Mostrar clientes cuentas.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the list
	 */
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
	
	/**
	 * Modificar consumo.
	 *
	 * @param oConsumoVO the o consumo vo
	 * @return the string
	 */
	
	
	
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

	/**
	 * Modificar cliente.
	 *
	 * @param oClienteVOAntiguo the o cliente vo antiguo
	 * @param oClienteVONuevo the o cliente vo nuevo
	 * @return the string
	 */

	public String modificarCliente(domain.ClienteVO oClienteVOAntiguo, domain.ClienteVO oClienteVONuevo){
		PersistentTransaction t;
		try {
			if(oClienteVOAntiguo != null || oClienteVONuevo != null){
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
				lormClienteHist.setFecha_modificacion(fechaActual());
				
				

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
				return "cliente modificado";} else {
					return "campos vacios";
				}
		} catch (PersistentException e) {
			e.printStackTrace();
			return "error persistencia";

		}  catch (Exception ex){
			ex.printStackTrace();
			return "credenciales invalidas";
		}
	}



	/**
	 * Desactivar cuenta.
	 *
	 * @param oCuentaVO the o cuenta vo
	 * @return the string
	 */
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

	/*
	public List<domain.ClienteVO> mostrarClientes2(domain.ClienteVO oClienteVO) {
		List<domain.ClienteVO> clientesIngresados = new ArrayList<domain.ClienteVO>();
			try{
			orm.Cliente[] clientes = orm.ClienteDAO.listClienteByQuery(
					null, null);
			for (int i = 0; i < clientes.length; i++) {
				domain.LoginVO CLlogin = new domain.LoginVO(clientes[i].getId_login().getToken(),
						clientes[i].getId_login().getFecha_logeo(), clientes[i].getId_login().getFecha_fin(),
						new domain.AdministradorVO(clientes[i].getId_login().getId_administrador().getUser(),
								clientes[i].getId_login().getId_administrador().getPassword()));
				clientesIngresados.add(new domain.ClienteVO(clientes[i].getRut(), clientes[i].getNombres(), clientes[i]
						.getApellido_materno(), clientes[i].getApellido_paterno(),clientes[i].getTelefono(), clientes[i].getEmail(),
						clientes[i].getDireccion(), null));
			}
			return clientesIngresados;

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}*/

	
	
	/*public*/ /*List<domain.ClienteVO>*//*String mostrarClientesHistoricos(domain.ClienteVO oClienteVO){
		if(oClienteVO == null){
			return "cliente vacio";
		}
		// TODO: Terminar metodo
		List<domain.ClienteVO> clientesIngresados = new ArrayList<domain.ClienteVO>();
		PersistentTransaction t;
		try {
			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
			Cliente_historico[] clientesHistoricos = orm.Cliente_historicoDAO
					.listCliente_historicoByQuery("rut = '"+oClienteVO.getRut()+"' and id_login.id_administrador.user = 'neumatico'", null);
			
			return "**** Longitud consulta"+clientesHistoricos.length;
		} catch (PersistentException e) {
			return e.toString();
			// TODO Auto-generated catch block
			
		}
		
		
		
	}*/
	
	/**
	 * Mostrar clientes historicos.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the list
	 */
	
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
	
	/**
	 * Mostrar clientes.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the array list
	 */
	
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
	/**
	 * Registrar administrador.
	 *
	 * @param oAdministradorVO the o administrador vo
	 * @return the string
	 */
	public String registrarAdministrador(domain.AdministradorVO oAdministradorVO){
		PersistentTransaction t;
		try {

			if(oAdministradorVO != null) {

				t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				orm.Administrador lormAdministrador = orm.AdministradorDAO.createAdministrador();
				lormAdministrador.setUser(oAdministradorVO.getUser());
				lormAdministrador.setPassword(oAdministradorVO.getPassword());
				orm.AdministradorDAO.save(lormAdministrador);
				t.commit();
				return "ingreso exitoso de administrador";} else {
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



	/**
	 * Generar token.
	 *
	 * @return the string
	 */
	private String generarToken(){
		/*
		 * Generar cadena aleatoria de 32 caracteres alfabeticos
		 */
		char[] token = new char[32];
		for(int i=0;i<32;i++){
			token[i] = (char) ((Math.random()*25) + 65);
		}
		return String.valueOf(token);
	}

	/**
	 * Fecha actual.
	 *
	 * @return the string
	 */
	private String fechaActual() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return hourdateFormat.format(date);
	}
	
	/**
	 * Fecha actual mas cinco.
	 *
	 * @return the string
	 */
	private String fechaActualMasCinco() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return hourdateFormat.format(date.getTime()+5*60000);
	}

	/**
	 * Logear.
	 *
	 * @param oAdministradorVO the o administrador vo
	 * @return the string
	 */
	
	
	
	
	public LoginVO logear(domain.AdministradorVO oAdministradorVO){
		PersistentTransaction t;
		try {
			
			
			
			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
			String tokenActual = generarToken();

			orm.Login lormLogin = orm.LoginDAO.createLogin();
			lormLogin.setFecha_logeo(fechaActual());
			lormLogin.setSesionActiva("S");
			lormLogin.setToken(tokenActual);
			lormLogin.setFecha_fin(fechaActualMasCinco());
			
			LoginVO loginvo = new LoginVO();
			loginvo.setAdministradorVO(oAdministradorVO);
			loginvo.setFecha_logeo(fechaActual());
			loginvo.setToken(tokenActual);
			loginvo.setFecha_fin(fechaActualMasCinco());
			
			
			/*
			 * Se arma la consulta para que compruebe si existe el usuario o contraseña especificados
			 */
			
			String condLogin = "user = '"+oAdministradorVO.getUser() 
					+"' and password = '"+oAdministradorVO.getPassword()+"'";
			
			orm.Administrador adminLogeadoORM = orm.AdministradorDAO.loadAdministradorByQuery(condLogin, null);
			lormLogin.setId_administrador(adminLogeadoORM);
			orm.LoginDAO.save(lormLogin);
			t.commit();
			return loginvo;

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception ex){
			return null;
		}
	}


	/**
	 * Registrar cliente.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the string
	 */
	public String registrarCliente(domain.ClienteVO oClienteVO){
		PersistentTransaction t;
		try {

			if(oClienteVO != null){

				t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();

				// Primero comprobar que la sesion actual esta activa, o que el token sea valido
				// comprobar();
				// Luego comprobar si el cliente o login vienen vacíos

				orm.Cliente lormCliente = orm.ClienteDAO.createCliente();
				lormCliente.setRut(oClienteVO.getRut());
				lormCliente.setNombres(oClienteVO.getNombres());
				lormCliente.setApellido_materno(oClienteVO.getApellido_materno());
				lormCliente.setApellido_paterno(oClienteVO.getApellido_paterno());
				lormCliente.setTelefono(oClienteVO.getTelefono());
				lormCliente.setEmail(oClienteVO.getEmail());
				lormCliente.setDireccion(oClienteVO.getDireccion());
				lormCliente.setFecha_creacion(fechaActual());

				/*String userTemp = "admin";
			String passTemp = "admin";

			String token = "HEBANXSXHMLNTFUXEDPRQGVEDBMCIOHJ";
				 */

				/*String condLogin = "user = '"+oClienteVO.getLoginVO().getAdministradorVO().getUser()+"'"+
						" and password = '"+oClienteVO.getLoginVO().getAdministradorVO().getPassword()+"'";*/

				//JOptionPane.showMessageDialog(null, condLogin);
				
				
			    //JOptionPane.showMessageDialog(null, oClienteVO.getLoginVO().getToken());
				
				String logCond = "token = '"+oClienteVO.getLoginVO().getToken()+"'";

				orm.Login loginAdminORM = orm.LoginDAO.loadLoginByQuery(logCond, null);
				//orm.Administrador adminLogeadoORM = orm.AdministradorDAO.loadAdministradorByQuery("administrador.token = '"+oClienteVO.getLoginVO().getToken()+"'", null);

				//loginAdminORM.setId_administrador(adminLogeadoORM);
				lormCliente.setId_login(loginAdminORM);



				/*
				 * Guarda cliente con datos de login y admin
				 */
				orm.ClienteDAO.save(lormCliente);


				t.commit();
				return "cliente ingresado"; } else {
					return "campos vacios";
				}
		} catch (PersistentException e) {
			e.printStackTrace();
			return "error persistencia";

		}  catch (Exception ex){
			ex.printStackTrace();
			return "credenciales invalidas";
		}
	}



	/**
	 * Registrar cuenta.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the string
	 */
	public String registrarCuenta(domain.ClienteVO oClienteVO){
		PersistentTransaction t;
		try {
			/*
			 * Se asigna la cuenta al cliente especificado por parametros, un cliente solo
			 * puede tener una cuenta
			 */
			
			System.out.println("USER ADM: "+oClienteVO.getLoginVO().getAdministradorVO().getUser());
			System.out.println("TOKEN: "+oClienteVO.getLoginVO().getToken());
			
			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();

			/*
			 * TODO: reconocer solo por rut
			 */


			/*String userTemp = "admin";
String passTemp = "admin";

String token = "HEBANXSXHMLNTFUXEDPRQGVEDBMCIOHJ";*/

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



	/**
	 * Registrar consumo.
	 *
	 * @param oConsumoVO the o consumo vo
	 * @return the string
	 */
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
