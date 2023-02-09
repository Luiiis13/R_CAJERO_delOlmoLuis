package modelo.dto;

/***
 * Clase que sirve para sacar los datos de telefono de la base de datos a la
 * aplicacion
 * 
 * @author Luis
 *
 */
public class TelefonoDTO {
	private int id;
	private float saldo;
	private int idTarjetaAsociada;
	private int numero;

	public TelefonoDTO(int id, int numero, float saldo, int idTarjetaAsociada) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.idTarjetaAsociada = idTarjetaAsociada;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
