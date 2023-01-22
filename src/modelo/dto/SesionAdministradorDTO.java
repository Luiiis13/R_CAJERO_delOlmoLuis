package modelo.dto;

public class SesionAdministradorDTO {
	private int id;
	private String nombre;
	private String contraseña;
	private String dni;

	public SesionAdministradorDTO() {

	}

	public SesionAdministradorDTO(int id, String nombre, String contraseña,String dni) {
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.dni=dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
