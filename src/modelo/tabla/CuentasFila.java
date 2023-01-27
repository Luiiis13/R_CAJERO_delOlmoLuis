package modelo.tabla;

public class CuentasFila {
	private int id;
	private String numero;
	private String iban;
	private float saldo;
	private int id_usuario;
	private boolean seleccionable;

	public CuentasFila(int id, String numero, String iban, float saldo, int id_usuario,
			boolean seleccionable) {
		super();
		this.id = id;
		this.numero = numero;
		this.iban = iban;
		this.saldo = saldo;
		this.id_usuario = id_usuario;
		this.seleccionable = seleccionable;
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

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public boolean isSeleccionable() {
		return seleccionable;
	}

	public void setSeleccionable(boolean seleccionable) {
		this.seleccionable = seleccionable;
	}

	public int getId() {
		return id;
	}
}
