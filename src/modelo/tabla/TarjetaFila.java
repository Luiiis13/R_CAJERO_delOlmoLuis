package modelo.tabla;

import java.sql.Date;

public class TarjetaFila {
	private int id;
	private String numero;
	private Date fecha_expiracion;
	private int cvv;
	private int pin;
	private boolean seleccionable;
	private boolean bloqueado;
	private int idCuentaAsociada;

	public TarjetaFila(int id, String numero, Date fecha_expiracion, int cvv, int pin, boolean seleccionable,
			boolean bloqueado, int idCuentaAsociada) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha_expiracion = fecha_expiracion;
		this.cvv = cvv;
		this.pin = pin;
		this.seleccionable = seleccionable;
		this.bloqueado = bloqueado;
		this.idCuentaAsociada = idCuentaAsociada;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getIdCuentaAsociada() {
		return idCuentaAsociada;
	}

	public void setIdCuentaAsociada(int idCuentaAsociada) {
		this.idCuentaAsociada = idCuentaAsociada;
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

	public boolean isSeleccionable() {
		return seleccionable;
	}

	public void setSeleccionable(boolean seleccionable) {
		this.seleccionable = seleccionable;
	}

	public int getId() {
		return id;
	}
}
