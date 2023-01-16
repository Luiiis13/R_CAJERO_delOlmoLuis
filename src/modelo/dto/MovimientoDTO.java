package modelo.dto;

import java.sql.Date;

public class MovimientoDTO {

	private int id;
	private String tipo;
	private Date fechaDelMovimiento;
	private int idTarjetaAsociada;

	public MovimientoDTO(int id, Date fechaDelMovimiento, String tipo, int idTarjetaAsociada) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fechaDelMovimiento = fechaDelMovimiento;
		this.idTarjetaAsociada = idTarjetaAsociada;
	}

	public int getIdTarjetaAsociada() {
		return idTarjetaAsociada;
	}

	public void setIdTarjetaAsociada(int idTarjetaAsociada) {
		this.idTarjetaAsociada = idTarjetaAsociada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaDelMovimiento() {
		return fechaDelMovimiento;
	}

	public void setFechaDelMovimiento(Date fechaDelMovimiento) {
		this.fechaDelMovimiento = fechaDelMovimiento;
	}
}
