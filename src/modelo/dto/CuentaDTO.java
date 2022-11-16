package modelo.dto;

public class CuentaDTO {

	private int id;
	private int numero;
	private String iban;
	private float sueldo;
	private int tarjetaAsociada;
	private int id_usuario;

	public CuentaDTO(int id, int numero, String iban, float sueldo, int tarjetaAsociada, int id_usuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.iban = iban;
		this.sueldo = sueldo;
		this.tarjetaAsociada = tarjetaAsociada;
		this.id_usuario = id_usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getTarjetaAsociada() {
		return tarjetaAsociada;
	}

	public void setTarjetaAsociada(int tarjetaAsociada) {
		this.tarjetaAsociada = tarjetaAsociada;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}
