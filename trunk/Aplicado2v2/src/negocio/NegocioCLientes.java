package negocio;

import java.util.ArrayList;
import java.util.List;

import generico.Genericos;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.AdministradorVO;
import domain.ClientesVO;
import domain.LoginVO;
import validar.ValClientes;

public class NegocioCLientes {
	private static final int ROW_COUNT = 100;
	
	public boolean consultaCliente(String query){
		boolean resp=true;
	try {
		orm.Cliente cliente=orm.ClienteDAO.loadClienteByQuery(query, null);
		if(cliente==null){
			resp=false;
		}else resp=true;
	} catch (PersistentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resp;
	}
	
	
	
	public String registrarClientes(domain.ClientesVO clientesVO){
		if(ValClientes.validarCampos(clientesVO)==false){
			 PersistentTransaction t;
			 try {
				 t=orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				 String queryUsuario="user='"+clientesVO.getRut()+"'";
				 if(consultaCliente(queryUsuario)==false){
					try {
					 orm.Cliente lormCliente=orm.ClienteDAO.createCliente();
					 lormCliente.setRut(clientesVO.getRut());
					 lormCliente.setNombres(clientesVO.getNombres());
					 lormCliente.setApellido_materno(clientesVO.getApellido_materno());
					 lormCliente.setApellido_paterno(clientesVO.getApellido_paterno());
					 lormCliente.setTelefono(clientesVO.getTelefono());
					 lormCliente.setEmail(clientesVO.getEmail());
					 lormCliente.setDireccion(clientesVO.getDireccion());
					 lormCliente.setFecha_creacion(Genericos.fechaActual());
					 
					 String queryLogin="TOKEN='"+clientesVO.getLoginVO().getToken()+"'";
					 orm.Login login=orm.LoginDAO.loadLoginByQuery(queryLogin, null);
					 
					 lormCliente.setId_login(login);
					 orm.ClienteDAO.save(lormCliente);
					 t.commit();
				     return "Registro Exitoso";
					} catch (PersistentException e) {
						// TODO: handle exception
						e.printStackTrace();
						return "error persistencia";					}
					 
					 
				 }else return "Usuario Existente";
				
			} catch (Exception e) {
				// TODO: handle exception
				return "credenciales invalidas";

			}
		}else return "Campos Nulos";
		
	}

	 public List<domain.ClientesVO> mostrarClientes(domain.ClientesVO oClienteVO){
		 List<domain.ClientesVO>clientes=new ArrayList<domain.ClientesVO>();
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

                 orm.Cliente[] cliente= orm.ClienteDAO.listClienteByQuery(condicion, null);
         		int length = Math.min(cliente.length, ROW_COUNT);
         		
         		for (int i = 0; i < length; i++) {
         			domain.LoginVO loginVORM=new LoginVO(cliente[i].getId_login().getId_login(), 
         					                             cliente[i].getId_login().getToken(),
         					                            cliente[i].getId_login().getFecha_logeo(),
         					                            cliente[i].getId_login().getFecha_fin(),
         					                             new AdministradorVO(cliente[i].getId_login().getId_administrador().getId_administrador(),
         					                            		cliente[i].getId_login().getId_administrador().getUser(),
         					                            		cliente[i].getId_login().getId_administrador().getPassword()),       					                             
         					                            cliente[i].getId_login().getSesionActiva());
         			
         			
         			clientes.add(new ClientesVO(cliente[i].getId_cliente(),
         					                    cliente[i].getRut(),
         					                   cliente[i].getNombres(),
         					                  cliente[i].getApellido_materno(),
         					                 cliente[i].getApellido_paterno(),
         					                cliente[i].getTelefono(),
         					               cliente[i].getEmail(),
         					              cliente[i].getDireccion(),
         					             cliente[i].getFecha_creacion(), 		
         					             loginVORM));
         			
         			
         		}
                
                 
                 
                 return clientes;
         } catch (PersistentException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
                 return null;
         }

 }

	 public String modificarCliente(domain.ClientesVO oClienteVOAntiguo, domain.ClientesVO oClienteVONuevo){
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
                         lormClienteHist.setFecha_modificacion(Genericos.fechaActual());



                         /*String userTemp = "admin";
                 String passTemp = "admin";

                 String token = "HEBANXSXHMLNTFUXEDPRQGVEDBMCIOHJ";
                          */

                         /*      String condLogin = "user = '"+oClienteVOAntiguo.getLoginVO().getAdministradorVO().getUser()  
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

	 
}
