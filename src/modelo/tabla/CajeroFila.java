package modelo.tabla;

/***
 * Clase que sirve como modelo de cajero DTO para poder hacer las tablas de la
 * vista y asi no modificar los verdaderos modelos que sirven para la base de
 * datos
 * 
 * @author Luis
 *
 */
public class CajeroFila {
	private int id;
	private String ubicacion;
	private boolean seleccionable;

	public CajeroFila(int id, String ubicacion, boolean seleccionable) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.seleccionable = seleccionable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean isSeleccionable() {
		return seleccionable;
	}

	public void setSeleccionable(boolean seleccionable) {
		this.seleccionable = seleccionable;
	}
}
