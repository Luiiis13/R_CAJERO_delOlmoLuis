package modelo.dto;

import java.sql.Date;

public class MovimientoDTO {

	private int id;
	private String tipo; 
	private Date fechaDelMovimiento;
private int cuentaAsociada;
	public MovimientoDTO(int id,  Date fechaDelMovimiento,String tipo,int cuentaAsociada ) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fechaDelMovimiento = fechaDelMovimiento;
		this.cuentaAsociada=cuentaAsociada;
	}

	public int getCuentaAsociada() {
		return cuentaAsociada;
	}

	public void setCuentaAsociada(int cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
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
