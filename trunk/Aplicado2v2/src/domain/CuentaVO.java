package domain;

public class CuentaVO {
	
	private int id_cuenta;
    /** The es activa. */
    private String esActiva;
   
    /** The cliente vo. */
    private ClientesVO clientesVO;
   
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
    public ClientesVO getClientesVO() {
            return clientesVO;
    }
   
    /**
     * Sets the cliente vo.
     *
     * @param clienteVO the new cliente vo
     */
    public void setClienteVO(ClientesVO clientesVO) {
            this.clientesVO = clientesVO;
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
    public CuentaVO(String esActiva, ClientesVO clientesVO, LoginVO loginVO) {
            super();
            this.esActiva = esActiva;
            this.clientesVO = clientesVO;
            this.loginVO = loginVO;
    }

    public CuentaVO() {
            super();
    }

	public CuentaVO(int id_cuenta, String esActiva, ClientesVO clientesVO,
			LoginVO loginVO) {
		super();
		this.id_cuenta = id_cuenta;
		this.esActiva = esActiva;
		this.clientesVO = clientesVO;
		this.loginVO = loginVO;
	}

	public int getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public void setClientesVO(ClientesVO clientesVO) {
		this.clientesVO = clientesVO;
	}
    

}
