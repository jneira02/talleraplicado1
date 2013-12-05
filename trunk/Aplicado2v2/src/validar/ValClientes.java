package validar;

public class ValClientes {

	static public boolean validarCampos(domain.ClientesVO clientesVO){
		if(clientesVO==null || clientesVO.getRut()==" "|| clientesVO.getNombres()==" " ||
		   clientesVO.getApellido_materno()==" "||clientesVO.getApellido_paterno()==" "||
		   clientesVO.getTelefono()==" "|| clientesVO.getEmail()==" "|| clientesVO.getDireccion()==" "
		   ){
			return true;
		}
		else return false;	
	}
}
