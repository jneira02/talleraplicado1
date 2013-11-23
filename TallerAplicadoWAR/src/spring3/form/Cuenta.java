package spring3.form;



public class Cuenta implements java.io.Serializable{
	/** The es activa. */
	private String esActiva;
	
	/** The cliente vo. */
	private Cliente cliente;
	
	/** The login vo. */
	private Login login;

	public String getEsActiva() {
		return esActiva;
	}

	public void setEsActiva(String esActiva) {
		this.esActiva = esActiva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Cuenta(String esActiva, Cliente cliente, Login login) {
		super();
		this.esActiva = esActiva;
		this.cliente = cliente;
		this.login = login;
	}

	public Cuenta() {
		super();
	}
	
	
	
}
