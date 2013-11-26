/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTaller1Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByQuery(null, null);
			// Update the properties of the persistent object
			orm.ContactoDAO.save(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Contacto by ContactoCriteria");
		orm.ContactoCriteria lormContactoCriteria = new orm.ContactoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormContactoCriteria.uid.eq();
		System.out.println(lormContactoCriteria.uniqueContacto());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTaller1Data retrieveAndUpdateTaller1Data = new RetrieveAndUpdateTaller1Data();
			try {
				retrieveAndUpdateTaller1Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateTaller1Data.retrieveByCriteria();
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
