/*
 * 
 */
package webservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument.WhiteSpace.Value;
import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.transform.ResultTransformer;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.google.gson.Gson;

import orm.Cliente_historico;
import orm.Cliente_historicoCriteria;
import domain.AdministradorVO;
import domain.ClienteVO;
import domain.Cliente_historicoVO;
import domain.ConsumoVO;
import domain.CuentaVO;
import domain.LoginVO;


// TODO: Auto-generated Javadoc




/**
 * The Class ServicioWeb.
 */

/*
 * Autor: Mauricio Cuevas
 */

public class ServicioWeb {


	/**
	 * Mostrar clientes cuentas.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the list
	 */
	public List<domain.ConsumoVO> mostrarClientesConsumos(domain.ClienteVO oClienteVO){
		return new negocio.Consumo().mostrarClientesConsumos(oClienteVO);
	}

	/**
	 * Modificar consumo.
	 *
	 * @param oConsumoVO the o consumo vo
	 * @return the string
	 */

	public String modificarConsumo(domain.ConsumoVO oConsumoVO){
		return new negocio.Consumo().modificarConsumo(oConsumoVO);
	}

	/**
	 * Modificar cliente.
	 *
	 * @param oClienteVOAntiguo the o cliente vo antiguo
	 * @param oClienteVONuevo the o cliente vo nuevo
	 * @return the string
	 */

	public String modificarCliente(domain.ClienteVO oClienteVOAntiguo, domain.ClienteVO oClienteVONuevo){
		return new negocio.Cliente().modificarCliente(oClienteVOAntiguo, oClienteVONuevo);
	}



	/**
	 * Desactivar cuenta.
	 *
	 * @param oCuentaVO the o cuenta vo
	 * @return the string
	 */
	public String desactivarCuenta(domain.CuentaVO oCuentaVO){
		return new negocio.Cuenta().desactivarCuenta(oCuentaVO);
	}
	/**
	 * Mostrar clientes historicos.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the list
	 */

	public List<domain.Cliente_historicoVO> mostrarClientesHistoricos(domain.ClienteVO oClienteVO){
		return new negocio.Cliente().mostrarClientesHistoricos(oClienteVO);
	}

	/**
	 * Mostrar clientes.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the array list
	 */

	public List<domain.ClienteVO> mostrarClientes(domain.ClienteVO oClienteVO){
		return new negocio.Cliente().mostrarClientes(oClienteVO);

	}
	/**
	 * Registrar administrador.
	 *
	 * @param oAdministradorVO the o administrador vo
	 * @return the string
	 */
	
	public String registrarAdministrador(domain.AdministradorVO oAdministradorVO){
		return new negocio.Administrador().registrarAdministrador(oAdministradorVO);
	}

	/**
	 * Logear.
	 *
	 * @param oAdministradorVO the o administrador vo
	 * @return the string
	 */
	public LoginVO logear(domain.AdministradorVO oAdministradorVO){
		return new negocio.Login().logear(oAdministradorVO);
	}


	/**
	 * Registrar cliente.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the string
	 */
	public String registrarCliente(domain.ClienteVO oClienteVO){
		return new negocio.Cliente().registrarCliente(oClienteVO);
	}
	/**
	 * Registrar cuenta.
	 *
	 * @param oClienteVO the o cliente vo
	 * @return the string
	 */
	public String registrarCuenta(domain.ClienteVO oClienteVO){
		return new negocio.Cuenta().registrarCuenta(oClienteVO);
	}
	/**
	 * Registrar consumo.
	 *
	 * @param oConsumoVO the o consumo vo
	 * @return the string
	 */
	public String registrarConsumo(domain.ConsumoVO oConsumoVO){
		return new negocio.Consumo().registrarConsumo(oConsumoVO);
	}
}
