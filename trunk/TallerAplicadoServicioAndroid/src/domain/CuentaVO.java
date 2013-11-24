package domain;

// TODO: Auto-generated Javadoc
/**
 * The Class CuentaVO.
 */
public class CuentaVO {
	
	/** The es activa. */
	private String esActiva;
	
	/** The cliente vo. */
	private ClienteVO clienteVO;
	
	/** The login vo. */
	private LoginVO loginVO;
	
	/**
	 * Gets the es activa.
	 *
	 * @return the es activa
	 */
	public String getEsActiva() {
		return esActiva;
	}
	
	/**
	 * Sets the es activa.
	 *
	 * @param esActiva the new es activa
	 */
	public void setEsActiva(String esActiva) {
		this.esActiva = esActiva;
	}
	
	/**
	 * Gets the cliente vo.
	 *
	 * @return the cliente vo
	 */
	public ClienteVO getClienteVO() {
		return clienteVO;
	}
	
	/**
	 * Sets the cliente vo.
	 *
	 * @param clienteVO the new cliente vo
	 */
	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	/**
	 * Gets the login vo.
	 *
	 * @return the login vo
	 */
	public LoginVO getLoginVO() {
		return loginVO;
	}

	/**
	 * Sets the login vo.
	 *
	 * @param loginVO the new login vo
	 */
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	/**
	 * Instantiates a new cuenta vo.
	 *
	 * @param esActiva the es activa
	 * @param clienteVO the cliente vo
	 * @param loginVO the login vo
	 */
	public CuentaVO(String esActiva, ClienteVO clienteVO, LoginVO loginVO) {
		super();
		this.esActiva = esActiva;
		this.clienteVO = clienteVO;
		this.loginVO = loginVO;
	}

	public CuentaVO() {
		super();
	}
	
	
	
	
	
	
	
	
}
