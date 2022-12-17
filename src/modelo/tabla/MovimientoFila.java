package modelo.tabla;

import java.sql.Date;

public class MovimientoFila {

	private int id;
	private String tipo; 
	private Date fechaDelMovimiento;
	
	public MovimientoFila(int id,  Date fechaDelMovimiento,String tipo) {
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
