package modelo.dto;

public class MovimientoDTO {

	private int id;

	private int idCuentaOrigen;
	private int idCuentaDestino;
	private float Cantidad;
	private String fechaDelMovimiento;

	public MovimientoDTO(int id, int idCuentaOrigen, int idCuentaDestino, float cantidad, String fechaDelMovimiento) {
		super();
		this.id = id;
		this.idCuentaOrigen = idCuentaOrigen;
		this.idCuentaDestino = idCuentaDestino;
		Cantidad = cantidad;
		this.fechaDelMovimiento = fechaDelMovimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCuentaOrigen() {
		return idCuentaOrigen;
	}

	public void setIdCuentaOrigen(int idCuentaOrigen) {
		this.idCuentaOrigen = idCuentaOrigen;
	}

	public int getIdCuentaDestino() {
		return idCuentaDestino;
	}

	public void setIdCuentaDestino(int idCuentaDestino) {
		this.idCuentaDestino = idCuentaDestino;
	}

	public float getCantidad() {
		return Cantidad;
	}

	public void setCantidad(float cantidad) {
		Cantidad = cantidad;
	}

	public String getFechaDelMovimiento() {
		return fechaDelMovimiento;
	}

	public void setFechaDelMovimiento(String fechaDelMovimiento) {
		this.fechaDelMovimiento = fechaDelMovimiento;
	}
}
