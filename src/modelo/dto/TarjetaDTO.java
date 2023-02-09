package modelo.dto;

import java.sql.Date;

/***
 * Clase que sirve para sacar los datos de tarjeta de la base de datos a la
 * aplicacion
 * 
 * @author Luis
 *
 */
public class TarjetaDTO {
	private int id;
	private String numero;
	private Date fecha_expiracion;
	private int cvv;
	private int pin;
	private boolean bloqueado;
	private int IdCuentaAsociada;

	public TarjetaDTO(int id, String numero, Date fecha_expiracion, int cvv, int pin, boolean bloqueado,
			int IdCuentaAsociada) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha_expiracion = fecha_expiracion;
		this.cvv = cvv;
		this.pin = pin;
		this.bloqueado = bloqueado;
		this.IdCuentaAsociada = IdCuentaAsociada;
	}

	public int getIdCuentaAsociada() {
		return IdCuentaAsociada;
	}

	public void setIdCuentaAsociada(int idCuentaAsociada) {
		IdCuentaAsociada = idCuentaAsociada;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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
