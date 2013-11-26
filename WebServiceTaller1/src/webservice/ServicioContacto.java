package webservice;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import orm.Contacto;
import orm.ContactoDAO;

public class ServicioContacto {
	/** 
	 * Ingreso de Registro 
	 * @param oContactoVO 
	 * @return 
	 */ 
		
	
	public String modificarContacto(domain.ContactoVO oContactoVO, domain.ContactoVO oContactoVONuevo){ 
		PersistentTransaction t; 
		try { 
			t = orm.Taller1PersistentManager.instance().getSession().beginTransaction(); 
					

			try {
				if(oContactoVO.getApellido().isEmpty() || oContactoVO.getArea().isEmpty() ||
						oContactoVO.getCargo().isEmpty() ||	oContactoVO.getEmail().isEmpty() ||
						oContactoVO.getFax().isEmpty() || oContactoVO.getNombre().isEmpty() ||
						String.valueOf(oContactoVO.getTelefono()).isEmpty()){
					return "Algunos datos faltaron";
				}
				
				String condition = "";

				condition += "nombre = '"+oContactoVO.getNombre() + "' and ";
				condition += "apellido = '"+oContactoVO.getApellido() + "' and ";
				condition += "email = '"+oContactoVO.getEmail() + "' and ";
				condition += "telefono = '"+oContactoVO.getTelefono() + "' and ";
				condition += "cargo = '"+oContactoVO.getCargo() + "' and ";
				condition += "fax = '"+oContactoVO.getFax() + "' and ";
				condition += "area = '"+oContactoVO.getArea()+"'";

				JOptionPane.showMessageDialog(null,"condiciones: "+condition);

				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByQuery(condition, null); 
				// Initialize the properties of the persistent object here 
				lormContacto.setNombre(oContactoVONuevo.getNombre()); 
				lormContacto.setApellido(oContactoVONuevo.getApellido()); 
				lormContacto.setEmail(oContactoVONuevo.getEmail()); 
				lormContacto.setTelefono(oContactoVONuevo.getTelefono()); 
				lormContacto.setCargo(oContactoVONuevo.getCargo());
				lormContacto.setFax(oContactoVONuevo.getFax());
				lormContacto.setArea(oContactoVONuevo.getArea());
				System.out.println("Modificacion exitosa"); 
				orm.ContactoDAO.save(lormContacto); 
				t.commit(); 
				return "modifcacion exitosa"; 
			} 
			catch (Exception e) { 
				t.rollback();
				e.printStackTrace();
				return "Error-Rollback";
				
			} 
		} catch (PersistentException e1) { 
			// TODO Auto-generated catch block 
			e1.printStackTrace(); 
			return "Error persistencia"; 
		} 
	}
	

		public List<domain.ContactoVO> mostrarContacto(){ 
			List<domain.ContactoVO> contactos = new 
					ArrayList<domain.ContactoVO>(); 
			orm.Contacto[] ormContactos; 
			try { 
				ormContactos = orm.ContactoDAO.listContactoByQuery(null, null); 
				int length = ormContactos.length; 
				for (int i = 0; i < length; i++) { 
					System.out.println(ormContactos[i]); 
					contactos.add(new 
							domain.ContactoVO(ormContactos[i].getNombre(), 
									ormContactos[i].getApellido(), 
									ormContactos[i].getEmail(), 
									ormContactos[i].getTelefono(),
									ormContactos[i].getCargo(),
									ormContactos[i].getFax(),
									ormContactos[i].getArea())); 
				} 
				return contactos; 
			} catch (PersistentException e) { 
				// TODO Auto-generated catch block 
				e.printStackTrace(); 
				return null; 
			} 

		}

		public String eliminarContacto(domain.ContactoVO oContactoVO){ 
			PersistentTransaction t; 
			try { 
				t = orm.Taller1PersistentManager.instance().getSession().beginTransaction(); 


				try {
					String condition = "";
					// Initialize the properties of the persistent object here 
					/*lormContacto.setNombre(oContactoVO.getNombre()); 
				lormContacto.setApellido(oContactoVO.getApellido()); 
				lormContacto.setEmail(oContactoVO.getEmail()); 
				lormContacto.setTelefono(oContactoVO.getTelefono()); 
				lormContacto.setCargo(oContactoVO.getCargo());
				lormContacto.setFax(oContactoVO.getFax());
				lormContacto.setArea(oContactoVO.getArea());*/

					condition += "nombre = '"+oContactoVO.getNombre() + "' and ";
					condition += "apellido = '"+oContactoVO.getApellido() + "' and ";
					condition += "email = '"+oContactoVO.getEmail() + "' and ";
					condition += "telefono = '"+oContactoVO.getTelefono() + "' and ";
					condition += "cargo = '"+oContactoVO.getCargo() + "' and ";
					condition += "fax = '"+oContactoVO.getFax() + "' and ";
					condition += "area = '"+oContactoVO.getArea()+"'";

					// Initialize the properties of the persistent object here

					orm.Contacto lormContacto = new ContactoDAO().loadContactoByQuery(condition, null);

					JOptionPane.showMessageDialog(null,"borrado: "+orm.ContactoDAO.delete(lormContacto));
					System.out.println("Borrado exitoso"); 
					t.commit(); 
					return "borrado exitoso"; 
				} 
				catch (Exception e) {
					e.printStackTrace();
					t.rollback(); 
					return "Error-Rollback"; 
				} 
			} catch (PersistentException e1) { 
				// TODO Auto-generated catch block 
				e1.printStackTrace(); 
				return "Error persistencia"; 
			} 

		} 

		public String agregarContacto(domain.ContactoVO oContactoVO){ 
			PersistentTransaction t; 
			try { 
				t = orm.Taller1PersistentManager.instance().getSession().beginTransaction(); 
						

				try {
					if(oContactoVO.getApellido().isEmpty() || oContactoVO.getArea().isEmpty() ||
							oContactoVO.getCargo().isEmpty() ||	oContactoVO.getEmail().isEmpty() ||
							oContactoVO.getFax().isEmpty() || oContactoVO.getNombre().isEmpty() ||
							String.valueOf(oContactoVO.getTelefono()).isEmpty()){
						return "Algunos datos faltaron";

					}


					orm.Contacto lormContacto = orm.ContactoDAO.createContacto(); 
					// Initialize the properties of the persistent object here 
					lormContacto.setNombre(oContactoVO.getNombre()); 
					lormContacto.setApellido(oContactoVO.getApellido()); 
					lormContacto.setEmail(oContactoVO.getEmail()); 
					lormContacto.setTelefono(oContactoVO.getTelefono()); 
					lormContacto.setCargo(oContactoVO.getCargo());
					lormContacto.setFax(oContactoVO.getFax());
					lormContacto.setArea(oContactoVO.getArea());
					System.out.println("Ingreso Exitoso"); 
					orm.ContactoDAO.save(lormContacto); 
					t.commit(); 
					return "ingreso existoso"; 
				} 
				catch (Exception e) { 
					t.rollback(); 
					return "Error-Rollback"; 
				} 
			} catch (PersistentException e1) { 
				// TODO Auto-generated catch block 
				e1.printStackTrace(); 
				return "Error persistencia"; 
			} 
		}




	}
