package negocio;

import generico.Genericos;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import validar.ValClientes;

public class NegocioCLientes {
	
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

}
