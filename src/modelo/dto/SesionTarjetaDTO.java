package modelo.dto;

import java.sql.Date;
/***
 * Clase que sirve para sacar los datos de la sesion actual cuando entras con la tarjeta (opción comenzar) de la base de datos a la aplicacion 
 * @author Luis
 *
 */
public class SesionTarjetaDTO {
	private String numeroTarjeta;
	private int pin;
	private Date fechaExpiracion;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
