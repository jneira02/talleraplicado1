package domain;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginVO.
 */
public class LoginVO {
	
	/** The token. */
	private String token;
	
	/** The fecha_logeo. */
	private String fecha_logeo;
	
	/** The administrador vo. */
	private AdministradorVO administradorVO;
	
	/** The sesion activa. */
	private String sesionActiva;
	
	/** The fecha_fin. */
	private String fecha_fin;
	

	/**
	 * Gets the administrador vo.
	 *
	 * @return the administrador vo
	 */
	public AdministradorVO getAdministradorVO() {
		return administradorVO;
	}
	
	/**
	 * Sets the administrador vo.
	 *
	 * @param administradorVO the new administrador vo
	 */
	public void setAdministradorVO(AdministradorVO administradorVO) {
		this.administradorVO = administradorVO;
	}
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Gets the fecha_logeo.
	 *
	 * @return the fecha_logeo
	 */
	public String getFecha_logeo() {
		return fecha_logeo;
	}
	
	/**
	 * Sets the fecha_logeo.
	 *
	 * @param fecha_logeo the new fecha_logeo
	 */
	public void setFecha_logeo(String fecha_logeo) {
		this.fecha_logeo = fecha_logeo;
	}
	
	/**
	 * Gets the sesion activa.
	 *
	 * @return the sesion activa
	 */
	public String getSesionActiva() {
		return sesionActiva;
	}
	
	/**
	 * Sets the sesion activa.
	 *
	 * @param sesionActiva the new sesion activa
	 */
	public void setSesionActiva(String sesionActiva) {
		this.sesionActiva = sesionActiva;
	}
	
	

	/**
	 * Instantiates a new login vo.
	 *
	 * @param token the token
	 * @param fecha_logeo the fecha_logeo
	 * @param administradorVO the administrador vo
	 * @param sesionActiva the sesion activa
	 * @param fecha_fin the fecha_fin
	 */
	public LoginVO(String token, String fecha_logeo,
			AdministradorVO administradorVO, String sesionActiva,
			String fecha_fin) {
		super();
		this.token = token;
		this.fecha_logeo = fecha_logeo;
		this.administradorVO = administradorVO;
		this.sesionActiva = sesionActiva;
		this.fecha_fin = fecha_fin;
	}

	/**
	 * Gets the fecha_fin.
	 *
	 * @return the fecha_fin
	 */
	public String getFecha_fin() {
		return fecha_fin;
	}

	/**
	 * Sets the fecha_fin.
	 *
	 * @param fecha_fin the new fecha_fin
	 */
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	/**
	 * Instantiates a new login vo.
	 */
	public LoginVO() {
		super();
	}
	
	
	
	
	
	
	
	
	
}
