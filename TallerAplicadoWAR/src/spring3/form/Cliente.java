package spring3.form;



public class Cliente implements java.io.Serializable{
	private String rut;
	private String nombres;
	private String apellido_materno;
	private String apellido_paterno;
	private String telefono;
	private String email;
	private String direccion;
	private String fecha_creacion;
	
	private String userADM;
	
	private String passADM;
	
	private String tokenADM;
	
	
	
	public String getUserADM() {
		return userADM;
	}
	public void setUserADM(String userADM) {
		this.userADM = userADM;
	}
	public String getPassADM() {
		return passADM;
	}
	public void setPassADM(String passADM) {
		this.passADM = passADM;
	}
	public String getTokenADM() {
		return tokenADM;
	}
	public void setTokenADM(String tokenADM) {
		this.tokenADM = tokenADM;
	}
	private Login login;
	
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
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Cliente() {
		super();
	}
	public Cliente(String rut, String nombres, String apellido_materno,
			String apellido_paterno, String telefono, String email,
			String direccion, String fecha_creacion, String userADM,
			String passADM, String tokenADM, Login login) {
		super();
		this.rut = rut;
		this.nombres = nombres;
		this.apellido_materno = apellido_materno;
		this.apellido_paterno = apellido_paterno;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.fecha_creacion = fecha_creacion;
		this.userADM = userADM;
		this.passADM = passADM;
		this.tokenADM = tokenADM;
		this.login = login;
	}
	
	
	
	
	
	
}
