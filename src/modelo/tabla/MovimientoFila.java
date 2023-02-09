package modelo.tabla;

import java.sql.Date;

/***
 * Clase que sirve como modelo de movimiento DTO para poder hacer las tablas de
 * la vista y asi no modificar los verdaderos modelos que sirven para la base de
 * datos
 * 
 * @author Luis
 *
 */
public class MovimientoFila {

	private int id;
	private String tipo;
	private Date fechaDelMovimiento;

	public MovimientoFila(int id, Date fechaDelMovimiento, String tipo) {
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
