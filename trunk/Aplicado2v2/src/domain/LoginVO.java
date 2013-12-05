package domain;

public class LoginVO {
	private int id_login;
	private String token;
	private String fecha_logeo;
	private String fecha_fin;
	private AdministradorVO administradorVO;
	private String sesionActiva;
	
	public LoginVO() {
		super();
	}

	public LoginVO(String token, String fecha_logeo, String fecha_fin,
			AdministradorVO administradorVO) {
		super();
		this.token = token;
		this.fecha_logeo = fecha_logeo;
		this.fecha_fin = fecha_fin;
		this.administradorVO = administradorVO;
	}

	public LoginVO(int id_login, String token, String fecha_logeo,
			String fecha_fin, AdministradorVO administradorVO,
			String sesionActiva) {
		super();
		this.id_login = id_login;
		this.token = token;
		this.fecha_logeo = fecha_logeo;
		this.fecha_fin = fecha_fin;
		this.administradorVO = administradorVO;
		this.sesionActiva = sesionActiva;
	}

	public int getId_login() {
		return id_login;
	}

	public void setId_login(int id_login) {
		this.id_login = id_login;
	}

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

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public AdministradorVO getAdministradorVO() {
		return administradorVO;
	}

	public void setAdministradorVO(AdministradorVO administradorVO) {
		this.administradorVO = administradorVO;
	}

	public String getSesionActiva() {
		return sesionActiva;
	}

	public void setSesionActiva(String sesionActiva) {
		this.sesionActiva = sesionActiva;
	}



}
