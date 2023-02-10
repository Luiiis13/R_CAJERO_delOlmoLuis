package modelo.dto;
/***
 * Clase que sirve para sacar los datos de Bonobus de la base de datos a la
 * aplicacion
 * 
 * @author Luis
 *
 */
public class BonobusDTO {
	private int id;
	private float saldo;
	private int idTarjetaAsociada;

	public BonobusDTO(int id, float saldo, int idTarjetaAsociada) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.idTarjetaAsociada = idTarjetaAsociada;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
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

}
