package modelo.dto;

public class UsuarioDTO {
	private int id;
	private String nombre;
	private String dni;
	private String primerApellido;
	private boolean esAdmin;
	private String contrase�a;

	public UsuarioDTO(int id, String nombre, String dni, String primerApellido, boolean esAdmin,String contrase�a) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.primerApellido = primerApellido;
		this.esAdmin = esAdmin;
		this.contrase�a = contrase�a;

	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public boolean getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
}
