package modelo.dto;

public class SesionDTO {
	private int numeroTarjeta;
	private int pin;

	public SesionDTO(int numeroTarjeta, int pin) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.pin = pin;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
