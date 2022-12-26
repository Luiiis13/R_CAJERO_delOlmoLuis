package modelo.tabla;

public class CajeroFila {
	private int id;
	private String ubicacion;
	private boolean seleccionable;
	public CajeroFila(int id, String ubicacion,boolean seleccionable) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.seleccionable=seleccionable;
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
