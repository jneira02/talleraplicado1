package domain;

public class ClienteVO {
	private String rut;
	private String nombres;
	private String apellido_materno;
	private String apellido_paterno;
	private String telefono;
	private String email;
	private String direccion;
	private String fecha_creacion;
	private LoginVO loginVO;
	
	

	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	
	
	
	public ClienteVO(String rut, String nombres, String apellido_materno,
			String apellido_paterno, String telefono, String email,
			String direccion, String fecha_creacion,
			LoginVO loginVO) {
		super();
		this.rut = rut;
		this.nombres = nombres;
		this.apellido_materno = apellido_materno;
		this.apellido_paterno = apellido_paterno;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.fecha_creacion = fecha_creacion;
		this.loginVO = loginVO;
	}
	public ClienteVO() {
		super();
	}
	
	
	
	
	
	
	
	
}
