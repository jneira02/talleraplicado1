package webService;

import negocio.NegocioAdministracion;

public class ServicioAdministracion {
	private negocio.NegocioAdministracion nA=new NegocioAdministracion();
	
	public String registroAdmin(domain.AdministradorVO administradorVO){
		return nA.registroAdmin(administradorVO);
		}
	
	public domain.LoginVO logearAdmin(domain.AdministradorVO administradorVO){
		return nA.logearAdministrador(administradorVO);
	}

}
