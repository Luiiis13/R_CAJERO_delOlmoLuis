package modelo.tabla;

public class UsuarioFila {
	private int id;
	private String nombre;
	private int edad;
	private String primerApellido;
	private boolean isAdmin;
	private boolean seleccionable;
	
	public UsuarioFila(int id, String nombre, int edad, String primerApellido, boolean isAdmin, boolean seleccionable) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.primerApellido = primerApellido;
		this.isAdmin = isAdmin;
		this.seleccionable=seleccionable;
	}

	public int getId() {
		return id;
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

	public boolean isSeleccionable() {
		return seleccionable;
	}

	public void setSeleccionable(boolean seleccionable) {
		this.seleccionable = seleccionable;
	}
}
