package negocio;

import generico.Genericos;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.LoginVO;
import orm.Login;

public class NegocioAdministracion {
	private static final int ROW_COUNT = 100;
	
		public boolean consultaUsuario(String con){
			boolean resp=false;
			orm.Administrador admistrador;
			try {
				admistrador = orm.AdministradorDAO.loadAdministradorByQuery(con, null);
			
				if(admistrador==null){
					resp=false;
				}else resp=true;
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resp;
				
		}
	
		
	public String registroAdmin(domain.AdministradorVO administradorVO){
		if(administradorVO.getUser()!=" " || administradorVO.getPassword()!=" "){
			 PersistentTransaction t;
			 try {
				 t=orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				 String queryUsuario="user='"+administradorVO.getUser()+"'";
				 if(consultaUsuario(queryUsuario)==false){
					try {
						 orm.Administrador lormAdministrador=orm.AdministradorDAO.createAdministrador();
						 lormAdministrador.setUser(administradorVO.getUser());
						 lormAdministrador.setPassword(administradorVO.getPassword());
						 orm.AdministradorDAO.save(lormAdministrador);
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

			
		}else{
			return "Usuario o COntraseña Nula";
		}
		
		
	}

	public domain.LoginVO logearAdministrador(domain.AdministradorVO administradorVO){
		
		if(administradorVO.getUser()!=" " || administradorVO.getPassword()!=" " || administradorVO!=null){
			 PersistentTransaction t;
			 try {
				 t=orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				 
				 String queryUsuario="user='"+administradorVO.getUser()+
						 "' AND PASSWORD='"+administradorVO.getPassword()+"'";
				 if(consultaUsuario(queryUsuario)==true){
					try {
				orm.Administrador admistrador = orm.AdministradorDAO.loadAdministradorByQuery(queryUsuario, null);
				
				orm.Login lormLogin=orm.LoginDAO.createLogin();
				lormLogin.setToken(Genericos.tokenActual(administradorVO.getUser()));
				lormLogin.setFecha_logeo(Genericos.fechaActual());
				lormLogin.setFecha_fin(Genericos.fechaActualMasCinco());
				lormLogin.setId_administrador(admistrador);
				lormLogin.setSesionActiva("S");
				
				domain.LoginVO loginVO=new LoginVO(Genericos.tokenActual(administradorVO.getUser()),
						                           Genericos.fechaActual(),
						                           Genericos.fechaActualMasCinco(), 
						                           administradorVO);
				
				System.out.println("FECHA= "+loginVO.getFecha_fin());
				System.out.println("TOKEN="+loginVO.getToken());
				orm.LoginDAO.save(lormLogin);
				t.commit();
				return loginVO;
						
					} catch (PersistentException e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
						}
					 
					 
				 }else return null;
				
			} catch (Exception e) {
				// TODO: handle exception
				return null;

			}				
		}else return null;
		
		
	}
	
}
