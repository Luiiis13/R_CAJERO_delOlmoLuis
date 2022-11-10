package modelo.dto;

public class TarjetaDTO {
	private int id;
	private int numero;
	private String fecha_expiracion;
	private int cvv;
	private int pin;

	public TarjetaDTO(int id, int numero, String fecha_expiracion, int cvv, int pin) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha_expiracion = fecha_expiracion;
		this.cvv = cvv;
		this.pin = pin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha_expiracion() {
		return fecha_expiracion;
	}

	public void setFecha_expiracion(String fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
