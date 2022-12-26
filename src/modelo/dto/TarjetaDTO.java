package modelo.dto;

import java.sql.Date;

public class TarjetaDTO {
	private int id;
	private int numero;
	private Date fecha_expiracion;
	private int cvv;
	private int pin;
	private boolean bloqueado;

	public TarjetaDTO(int id, int numero, Date fecha_expiracion, int cvv, int pin,boolean bloqueado) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha_expiracion = fecha_expiracion;
		this.cvv = cvv;
		this.pin = pin;
		this.bloqueado = bloqueado;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
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

	public Date getFecha_expiracion() {
		return fecha_expiracion;
	}

	public void setFecha_expiracion(Date fecha_expiracion) {
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
