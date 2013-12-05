package webService;

import negocio.NegocioCLientes;

public class ServicioCliente {
	private negocio.NegocioCLientes nC=new NegocioCLientes();
	
	public String registroCliente(domain.ClientesVO clientesVO){
		return nC.registrarClientes(clientesVO);
	}

}
