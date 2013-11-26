/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTaller1Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			// Initialize the properties of the persistent object here
			orm.ContactoDAO.save(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTaller1Data createTaller1Data = new CreateTaller1Data();
			try {
				createTaller1Data.createTestData();
			}
			finally {
				orm.Taller1PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
