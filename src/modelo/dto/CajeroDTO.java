package modelo.dto;
/***
 * Clase que sirve para sacar los datos de Cajero de la base de datos a la
 * aplicacion
 * 
 * @author Luis
 *
 */
public class CajeroDTO {

	private int id;
	private String ubicacion;

	public CajeroDTO(int id, String ubicacion) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
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
}