package modelo.dto;

import java.sql.Date;

public class MovimientoDTO {

	private int id;
	private String tipo; 
	private Date fechaDelMovimiento;

	public MovimientoDTO(int id,  Date fechaDelMovimiento,String tipo ) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fechaDelMovimiento = fechaDelMovimiento;
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
