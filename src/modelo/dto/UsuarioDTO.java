package modelo.dto;

public class UsuarioDTO {
	private int id;
	private String nombre;
	private int edad;
	private String primerApellido;
	private boolean isAdmin;
	private String contrase�a;

	public UsuarioDTO(int id, String nombre, int edad, String primerApellido, boolean isAdmin,String contrase�a) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.primerApellido = primerApellido;
		this.isAdmin = isAdmin;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
