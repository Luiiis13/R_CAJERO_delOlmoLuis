package modelo.dto;

public class UsuarioDTO {
	private int id;
	private String nombre;
	private String dni;
	private String primerApellido;
	private boolean esAdmin;
	private String contraseña;

	public UsuarioDTO(int id, String nombre, String dni, String primerApellido, boolean esAdmin,String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.primerApellido = primerApellido;
		this.esAdmin = esAdmin;
		this.contraseña = contraseña;

	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
