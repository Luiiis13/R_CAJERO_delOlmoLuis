package modelo.dto;

public class CuentaDTO {

	private int id;
	private String numero;
	private String iban;
	private float saldo;
	private int id_usuario;

	public CuentaDTO(int id, String numero, String iban, float saldo, int id_usuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.iban = iban;
		this.saldo = saldo;
		this.id_usuario = id_usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float sueldo) {
		this.saldo = sueldo;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}
