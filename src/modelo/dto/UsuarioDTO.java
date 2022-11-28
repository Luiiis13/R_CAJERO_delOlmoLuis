package modelo.dto;

public class UsuarioDTO {
	private int id;
	private String nombre;
	private int edad;
	private String primerApellido;
	private String rol;

	public UsuarioDTO(int id, String nombre, int edad, String primerApellido, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.primerApellido = primerApellido;
		this.rol = rol;

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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
