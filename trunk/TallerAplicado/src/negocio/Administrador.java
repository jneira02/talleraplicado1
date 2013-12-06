package negocio;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Administrador {
	
	public String registrarAdministrador(domain.AdministradorVO oAdministradorVO){
	
		if(oAdministradorVO!=null || oAdministradorVO.getUser()!=" " || oAdministradorVO.getPassword()!=" ")
		{
		PersistentTransaction t;

		try {
				t = orm.BDtalleraplicadoPersistentManager.instance().getSession().beginTransaction();
				orm.Administrador lormAdministrador = orm.AdministradorDAO.createAdministrador();
				lormAdministrador.setUser(oAdministradorVO.getUser());
				lormAdministrador.setPassword(oAdministradorVO.getPassword());
				orm.AdministradorDAO.save(lormAdministrador);
				t.commit();
				return "ingreso exitoso de administrador";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error persistencia";
		}  catch (Exception ex){
			return "credenciales invalidas";
		}	
	}return "valores Nulos";
	
	
	
	
	}
	

}
