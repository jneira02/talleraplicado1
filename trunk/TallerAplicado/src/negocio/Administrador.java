package negocio;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Administrador {
	public String registrarAdministrador(domain.AdministradorVO oAdministradorVO){
		PersistentTransaction t;

		try {

			if(oAdministradorVO != null || oAdministradorVO.getUser()!="" || oAdministradorVO.getPassword()!="") {

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
}
