package modelo.dto;

/***
 * Clase que sirve para sacar los datos de la sesion actual cuando entras con el
 * usuario (opci�n comenzar como administrador) de la base de datos a la
 * aplicacion
 * 
 * @author Luis
 *
 */
public class SesionAdministradorDTO {
	private int id;
	private String nombre;
	private String contrase�a;
	private String dni;

	public SesionAdministradorDTO() {

	}

	public SesionAdministradorDTO(int id, String nombre, String contrase�a, String dni) {
		this.id = id;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.dni = dni;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
}
