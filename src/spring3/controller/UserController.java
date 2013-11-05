package spring3.controller;

//import net.viralpatel.spring3.form.Contact;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import spring3.form.Administrador;
import spring3.form.Cliente;
import spring3.form.ClienteCuentasForm;
import spring3.form.Consumo;
import spring3.form.Login;
import spring3.form.ObjectForm;
import webservice.ServicioWebStub;
import webservice.ServicioWebStub.ClienteVO;
import webservice.ServicioWebStub.Cliente_historicoVO;
import webservice.ServicioWebStub.LoginVO;
import webservice.ServicioWebStub.*;

// TODO: Auto-generated Javadoc
/*
 * Autor: Mauricio Cuevas
 */

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Controller
@SessionAttributes
public class UserController {


	/**
	 * Sesion valida.
	 * 
	 * Comprueba si la sesion actual es valida, comprobando la duracion del token de los 5 minutos
	 *
	 * @param session the session
	 * @return true, if successful
	 */
	private boolean sesionValida(HttpSession session){
		try {if(session.getAttribute("loginvo") == null) return false;
		Date fechaActual = new Date();
		LoginVO loginvo = (LoginVO) session.getAttribute("loginvo");
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date fechaFin = formatter.parse(loginvo.getFecha_fin());
		System.out.println("FECHA FIN: "+fechaFin.toString());
		System.out.println("FECHA ACTUAL: "+fechaActual);
		System.out.println("ESTADO SESION: "+fechaFin.after(fechaActual));
		return fechaFin.after(fechaActual);} catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("loginvo", null);
			return false;
		}
	}

	/**
	 * Modificar cliente.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/modificarCliente")
	public ModelAndView modificarCliente(@ModelAttribute("Administrador") @Valid  Cliente cliente, BindingResult result, HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");

		session.setAttribute("cliente_completo", cliente);
		return new ModelAndView("ModificarCliente","command",cliente);
	}
	
	/**
	 * Mostrar cuentas.
	 *
	 * @param session the session
	 * @param cliente the cliente
	 * @return the model and view
	 */
	@RequestMapping("/estadoCuenta")
	public ModelAndView mostrarCuentas(HttpSession session, @Valid Cliente cliente) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		try {
			ObjectForm objectForm = new ObjectForm();
			
			try {
				ClienteVO clientevo = new ClienteVO();
				clientevo.setRut(cliente.getRut());
				ServicioWebStub oStub = new ServicioWebStub();
				MostrarClientesConsumos oMostrarClientesCONS = new MostrarClientesConsumos();
				oMostrarClientesCONS.setOClienteVO(clientevo);
				//oMostrarClientes.setOClienteVO(clientevo);
				MostrarClientesConsumosResponse objResponde =  oStub.mostrarClientesConsumos(oMostrarClientesCONS);
				ConsumoVO[] contacts2= objResponde.get_return();
				objectForm.setObjects(contacts2);
				session.setAttribute("clienterut", cliente.getRut());
				
				
				
				//JOptionPane.showMessageDialog(null,"token: "+ session.getAttribute("token").toString());
				return new ModelAndView("GestorCuentas","objectForm", objectForm);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ModelAndView("error", "message", "ERROR");
			}

			//return new ModelAndView("Logeado", "clientesRegistrados", "asd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "mensaje", "ERROR");
		}
	}

	/**
	 * Modificar cliente action.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/modificarClienteAction")
	public ModelAndView modificarClienteAction(@ModelAttribute("Administrador") @Valid  Cliente cliente, BindingResult result, HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		try {ServicioWebStub servicioInvocado = new ServicioWebStub();
		LoginVO loginvo = (LoginVO) session.getAttribute("loginvo");


		ClienteVO clienteVONuevo = new ClienteVO();

		clienteVONuevo.setApellido_materno(cliente.getApellido_materno());
		clienteVONuevo.setApellido_paterno(cliente.getApellido_paterno());
		clienteVONuevo.setDireccion(cliente.getDireccion());
		clienteVONuevo.setEmail(cliente.getEmail());
		clienteVONuevo.setNombres(cliente.getNombres());
		clienteVONuevo.setRut(cliente.getRut());
		clienteVONuevo.setTelefono(cliente.getTelefono());

		Cliente clienteAntiguoSession = (Cliente) session.getAttribute("cliente_completo");

		ClienteVO clienteAntiguoVO = new ClienteVO();
		clienteAntiguoVO.setApellido_materno(clienteAntiguoSession.getApellido_materno());
		clienteAntiguoVO.setApellido_paterno(clienteAntiguoSession.getApellido_paterno());
		clienteAntiguoVO.setDireccion(clienteAntiguoSession.getDireccion());
		clienteAntiguoVO.setEmail(clienteAntiguoSession.getEmail());
		clienteAntiguoVO.setNombres(clienteAntiguoSession.getNombres());
		clienteAntiguoVO.setTelefono(clienteAntiguoSession.getTelefono());
		clienteAntiguoVO.setRut(clienteAntiguoSession.getRut());


		clienteVONuevo.setLoginVO(loginvo);
		clienteAntiguoVO.setLoginVO(loginvo);
		ModificarCliente modificarClienteSTUB = new ModificarCliente();
		modificarClienteSTUB.setOClienteVONuevo(clienteVONuevo);
		modificarClienteSTUB.setOClienteVOAntiguo(clienteAntiguoVO);
		ModificarClienteResponse modificarClienteSTUBResponse = servicioInvocado.modificarCliente(modificarClienteSTUB);
		String mensaje = modificarClienteSTUBResponse.get_return();
		return new ModelAndView("saludo", "message", mensaje);
		}

		catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("saludo", "message", "error modificando");
		}
	}

	/**
	 * Abrir principal.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/Principal")
	public ModelAndView abrirPrincipal() {
		return new ModelAndView("Principal", "command", new Administrador());
	}

	/**
	 * Historial cambios.
	 *
	 * @param session the session
	 * @param cliente the cliente
	 * @return the model and view
	 */
	@RequestMapping("/historialCambios")
	public ModelAndView historial(HttpSession session, @Valid Cliente cliente) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		try {
			System.out.print("RUT DE CLIENTE SELECCIONADO: "+cliente.getRut());
			ObjectForm objectForm = new ObjectForm();
			//ClienteCuentasForm[] clientesModificados;
			
			try {
				ServicioWebStub oStub = new ServicioWebStub();
				ClienteVO clientevo = new ClienteVO();
				clientevo.setRut(cliente.getRut());
				MostrarClientesHistoricos oMostrarClientesHist = new MostrarClientesHistoricos();
				oMostrarClientesHist.setOClienteVO(clientevo);
				MostrarClientesHistoricosResponse objResponde =  oStub.mostrarClientesHistoricos(oMostrarClientesHist);
				Cliente_historicoVO[] contacts2= objResponde.get_return();
				//clientesModificados = new ClienteCuentasForm[contacts2.length];
				
				/*for(int i=0;i<contacts2.length;i++){
					clientesModificados[i] = new ClienteCuentasForm(
							contacts2[i].getRut(),
							contacts2[i].getNombres(),
							contacts2[i].getApellido_materno(),
							contacts2[i].getApellido_paterno(),
							contacts2[i].getTelefono(),
							contacts2[i].getEmail(),
							contacts2[i].getDireccion(),
							contacts2[i].getFecha_modificacion(),"",
							contacts2[i].getLoginVO().getAdministradorVO().getUser()
							);
				}*/
				
				
				objectForm.setObjects(contacts2);
				
				
				
				//JOptionPane.showMessageDialog(null,"token: "+ session.getAttribute("token").toString());
				return new ModelAndView("HistorialCambiosClientes","objectForm", objectForm);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ModelAndView("error", "message", "ERROR");
			}

			//return new ModelAndView("Logeado", "clientesRegistrados", "asd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "mensaje", "ERROR");
		}
	}

	/**
	 * Logear.
	 *
	 * @param admin the admin
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/logear")
	public ModelAndView logear(@ModelAttribute("Administrador") @Valid  Administrador admin, BindingResult result, HttpSession session) {
		try {
			//CUEK! if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
			
			if(session.getAttribute("token") != null){
				if(!sesionValida(session)) {
					session.removeAttribute("token");
					session.removeAttribute("loginvo");
					return new ModelAndView("saludo","message","sesion no valida, reingrese");
				}
				return new ModelAndView("MenuLogeado","command", "");
			}




			ServicioWebStub servicioInvocadoLogin = new ServicioWebStub();
			AdministradorVO adminVO = new AdministradorVO();
			adminVO.setUser(admin.getUser());
			adminVO.setPassword(admin.getPassword());
			Logear logearSTUB = new Logear();
			logearSTUB.setOAdministradorVO(adminVO);
			LogearResponse logearSTUBresponse = servicioInvocadoLogin.logear(logearSTUB);
			LoginVO logeoVO = logearSTUBresponse.get_return();
			session.setAttribute("loginvo", logearSTUBresponse.get_return());
			session.setAttribute("token", logeoVO.getToken());


			if(session.getAttribute("loginvo") == null){
				return new ModelAndView("saludo","message","credenciales invalidas");
			}

			return new ModelAndView("MenuLogeado","command", "");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ModelAndView("error", "message", "ERROR");
		}

		//return new ModelAndView("Logeado", "clientesRegistrados", "asd");

	}

	/**
	 * Mostrar clientes.
	 *
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/mostrarClientes")
	public ModelAndView mostrarClientes(HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		try {
			ObjectForm objectForm = new ObjectForm();
			
			try {
				ClienteVO clientevo = new ClienteVO();
				clientevo.setNombres("Juan");
				ServicioWebStub oStub = new ServicioWebStub();
				MostrarClientes oMostrarClientes = new MostrarClientes();
				//oMostrarClientes.setOClienteVO(clientevo);
				MostrarClientesResponse objResponde =  oStub.mostrarClientes(oMostrarClientes);
				ClienteVO[] contacts2= objResponde.get_return();
				objectForm.setObjects(contacts2);
				
				
				
				//JOptionPane.showMessageDialog(null,"token: "+ session.getAttribute("token").toString());
				return new ModelAndView("MostrarClientes","objectForm", objectForm);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ModelAndView("error", "message", "ERROR");
			}

			//return new ModelAndView("Logeado", "clientesRegistrados", "asd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "mensaje", "ERROR");
		}
	}

	/**
	 * Registro admin.
	 *
	 * @param admin the admin
	 * @param result the result
	 * @return the model and view
	 */



	@RequestMapping("/registroAdmin")
	public ModelAndView registroAdmin(@ModelAttribute("Administrador") @Valid  Administrador admin, BindingResult result) {
		try {
		

			ServicioWebStub servicioInvocado = new ServicioWebStub();
			AdministradorVO adminVO = new AdministradorVO();
			adminVO.setUser(admin.getUser());
			adminVO.setPassword(admin.getPassword());
			RegistrarAdministrador registroAdminSTUB = new RegistrarAdministrador();
			registroAdminSTUB.setOAdministradorVO(adminVO);
			RegistrarAdministradorResponse registroAdminSTUBResponse = servicioInvocado.registrarAdministrador(registroAdminSTUB);
			String mensaje = registroAdminSTUBResponse.get_return();
			return new ModelAndView("saludo", "message", mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "message", "ERROR");
		}
	}



	/**
	 * Registro clientes.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/registroClientes")
	public ModelAndView registroClientes(@ModelAttribute("Administrador") @Valid  Cliente cliente, BindingResult result, HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		return new ModelAndView("Cliente","command",new Cliente(
				"Ej: 179833107",
				"Ej: Juan Alejandro",
				"Ej: Cuevas","Ej: Guerrero",
				"Ej: 77329086",
				"Ej: mail@dominio.cl",
				"Ej: Av. Ercilla #1",
				"Ej: 05/11/2013",null,null,null,null));
	}
	
	/**
	 * Registro cuenta.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/activarCuentaAction")
	public ModelAndView registroCuenta(@ModelAttribute("Administrador") @Valid  Cliente cliente, BindingResult result, HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		System.out.println("RUT CUENTA CLI: "+session.getAttribute("clienterut"));
		
		LoginVO loginvo = (LoginVO) session.getAttribute("loginvo");
		ClienteVO clientevo = new ClienteVO();
		clientevo.setRut(session.getAttribute("clienterut").toString());
		clientevo.setLoginVO(loginvo);
		
		try {
			ServicioWebStub servicioInvocado = new ServicioWebStub();
			RegistrarCuenta registroCuentaSTUB = new RegistrarCuenta();
			registroCuentaSTUB.setOClienteVO(clientevo);
			RegistrarCuentaResponse registroCuentaResponse = servicioInvocado.registrarCuenta(registroCuentaSTUB);
			String mensaje = registroCuentaResponse.get_return();
			return new ModelAndView("saludo", "message", mensaje);
			
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("Cliente","command",new Cliente());
	}
	
	/**
	 * Registro consumo.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	
	
	
	@RequestMapping("/registrarConsumo")
	public ModelAndView registroConsumo(@ModelAttribute("Administrador") @Valid  Cliente cliente, BindingResult result, HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		//System.out.println("RUT SELECCIONADO: "+cliente.getRut()+"**");
		ClienteVO clienteVO = new ClienteVO();

		clienteVO.setApellido_materno(cliente.getApellido_materno());
		clienteVO.setApellido_paterno(cliente.getApellido_paterno());
		clienteVO.setDireccion(cliente.getDireccion());
		clienteVO.setEmail(cliente.getEmail());
		clienteVO.setNombres(cliente.getNombres());
		clienteVO.setRut(cliente.getRut());
		clienteVO.setTelefono(cliente.getTelefono());
		
		session.setAttribute("cliente", clienteVO);
		return new ModelAndView("Consumo","command",new Consumo(
				"Ej: Agua, Luz o Gas","Ej: m3, khw",0,0,0,"Ej: S o N","Ej: 05/11/2013",null));
	}
	
	/**
	 * Registro consumo action.
	 *
	 * @param consumo the consumo
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/registrarConsumoAction")
	public ModelAndView registroConsumoAction(@ModelAttribute("Administrador") @Valid  Consumo consumo, BindingResult result, HttpSession session) {
		if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
		//System.out.println("RUT SELECCIONADO: "+consumo.getCantidad_unidades()+"**");
		ConsumoVO consumovo = new ConsumoVO();
		
		consumovo.setCantidad_unidades(consumo.getCantidad_unidades());
		consumovo.setEsta_pagado(consumo.getEsta_pagado());
		consumovo.setFecha_vencimiento(consumo.getFecha_vencimiento());
		consumovo.setMonto_total(consumo.getMonto_total());
		consumovo.setMonto_unidad(consumo.getMonto_unidad());
		consumovo.setTipo_servicio(consumo.getTipo_servicio());
		consumovo.setUnidad_servicio(consumo.getUnidad_servicio());
		
		
		
		CuentaVO cuentavo = new CuentaVO();
		ClienteVO clientevo = (ClienteVO) session.getAttribute("cliente");
		LoginVO loginvo = (LoginVO) session.getAttribute("loginvo");
		
		clientevo.setLoginVO(loginvo);
		clientevo.setRut(session.getAttribute("clienterut").toString());
		cuentavo.setClienteVO(clientevo);
		cuentavo.setLoginVO(loginvo);
		consumovo.setCuentaVO(cuentavo);
		
		try {
			ServicioWebStub servicioInvocado = new ServicioWebStub();
			RegistrarConsumo registroConsumoSTUB = new RegistrarConsumo();
			registroConsumoSTUB.setOConsumoVO(consumovo);
			RegistrarConsumoResponse registroConsumoRESP = servicioInvocado.registrarConsumo(registroConsumoSTUB);
			String mensaje = registroConsumoRESP.get_return();
			return new ModelAndView("saludo", "message", mensaje);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "message", "ERROR");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "message", "ERROR");
		}
		
	}
	
	/**
	 * Registro clientes action.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @param session the session
	 * @return the model and view
	 */
	@RequestMapping("/registrarClienteAction")
	public ModelAndView registroClientesAction(@ModelAttribute("Administrador") @Valid  Cliente cliente, BindingResult result, HttpSession session) {
		try {
			if(!sesionValida(session)) return new ModelAndView("saludo","message","sesion no valida, reingrese");
			ServicioWebStub servicioInvocado = new ServicioWebStub();
			ClienteVO clienteVO = new ClienteVO();

			clienteVO.setApellido_materno(cliente.getApellido_materno());
			clienteVO.setApellido_paterno(cliente.getApellido_paterno());
			clienteVO.setDireccion(cliente.getDireccion());
			clienteVO.setEmail(cliente.getEmail());
			clienteVO.setNombres(cliente.getNombres());
			clienteVO.setRut(cliente.getRut());
			clienteVO.setTelefono(cliente.getTelefono());

			LoginVO loginvo = (LoginVO) session.getAttribute("loginvo");
			
			
			
			
			clienteVO.setLoginVO(loginvo);
			RegistrarCliente registroClienteSTUB = new RegistrarCliente();
			registroClienteSTUB.setOClienteVO(clienteVO);
			RegistrarClienteResponse registroClienteSTUBResponse = servicioInvocado.registrarCliente(registroClienteSTUB);
			String mensaje = registroClienteSTUBResponse.get_return();
			return new ModelAndView("saludo", "message", mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error", "message", "ERROR");
		}

	}
}