package modelo.tabla;

public class UsuarioFila {
	private int id;
	private String nombre;
	private String dni;
	private String primerApellido;
	private boolean isAdmin;
	private boolean seleccionable;
	private String contrase�a;
	
	public UsuarioFila(int id, String nombre, String dni, String primerApellido, boolean isAdmin, boolean seleccionable,String contrase�a) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.primerApellido = primerApellido;
		this.isAdmin = isAdmin;
		this.seleccionable=seleccionable;
		this.contrase�a=contrase�a;
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
