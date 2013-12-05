package negocio;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import utilitarios.Utilitario;
import domain.LoginVO;

public class Login {
	public LoginVO logear(domain.AdministradorVO oAdministradorVO){
		PersistentTransaction t;

		if(oAdministradorVO == null || oAdministradorVO.getUser().equals("") 
				|| oAdministradorVO.getPassword().equals("")){
			return null;
		}

		try {



			t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
			String tokenActual = Utilitario.generarToken();

			orm.Login lormLogin = orm.LoginDAO.createLogin();
			lormLogin.setFecha_logeo(utilitarios.Utilitario.fechaActual());
			lormLogin.setSesionActiva("S");
			lormLogin.setToken(tokenActual);
			lormLogin.setFecha_fin(Utilitario.fechaActualMasCinco());

			LoginVO loginvo = new LoginVO();
			loginvo.setAdministradorVO(oAdministradorVO);
			loginvo.setFecha_logeo(utilitarios.Utilitario.fechaActual());
			loginvo.setToken(tokenActual);
			loginvo.setFecha_fin(Utilitario.fechaActualMasCinco());


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
}
