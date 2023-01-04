package modelo.dto;

public class TelefonoDTO {
	private int id;
	private float saldo;
	private int idCuenta;
	private int numero;

	public TelefonoDTO(int id, int numero, float saldo, int idCuenta) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.idCuenta = idCuenta;
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

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getId() {
		return id;
	}

}
