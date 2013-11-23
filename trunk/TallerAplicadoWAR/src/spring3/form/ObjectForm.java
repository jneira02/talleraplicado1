/**
 * ContactForm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package spring3.form;

import webservice.ServicioWebStub.ClienteVO;

public class ObjectForm  implements java.io.Serializable {
	private java.lang.Object objects;

	public ObjectForm() {
	}

	public ObjectForm(
			java.lang.Object objects) {
		this.objects = objects;
	}
	
	public Object[] getArray(){
		return (Object[]) objects;
	}
	
	public ClienteVO[] getClienteArray(){
		return (ClienteVO[]) objects;
	}
	

	/**
	 * Gets the contacts value for this ContactForm.
	 * 
	 * @return contacts
	 */
	public java.lang.Object getObject() {
		return objects;
	}


	/**
	 * Sets the contacts value for this ContactForm.
	 * 
	 * @param contacts
	 */
	public void setObjects(java.lang.Object objects) {
		this.objects = objects;
	}


}
