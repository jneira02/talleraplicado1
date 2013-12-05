package domain;

public class AdministradorVO {
	private int id_administrador;
	private String user;
	private String password;
	
	public AdministradorVO() {
		super();
	}

	public AdministradorVO(int id_administrador, String user, String password) {
		super();
		this.id_administrador = id_administrador;
		this.user = user;
		this.password = password;
	}

	public int getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(int id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
