package modelo.dto;

public class UsuarioDTO {
private int id;
	private String nombre;
	private int edad;
	private String primerApellido;
	
	
	public UsuarioDTO(int id, String nombre, int edad, String primerApellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.primerApellido = primerApellido;
		
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

}
	
	

