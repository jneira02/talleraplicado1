package spring3.form;


public class Login implements java.io.Serializable{
	/** The token. */
	private String token;
	
	/** The fecha_logeo. */
	private String fecha_logeo;
	
	/** The administrador vo. */
	private Administrador administrador;
	
	/** The sesion activa. */
	private String sesionActiva;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFecha_logeo() {
		return fecha_logeo;
	}

	public void setFecha_logeo(String fecha_logeo) {
		this.fecha_logeo = fecha_logeo;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getSesionActiva() {
		return sesionActiva;
	}

	public void setSesionActiva(String sesionActiva) {
		this.sesionActiva = sesionActiva;
	}

	public Login(String token, String fecha_logeo, Administrador administrador,
			String sesionActiva) {
		super();
		this.token = token;
		this.fecha_logeo = fecha_logeo;
		this.administrador = administrador;
		this.sesionActiva = sesionActiva;
	}

	public Login() {
		super();
	}
	
	
	
}
