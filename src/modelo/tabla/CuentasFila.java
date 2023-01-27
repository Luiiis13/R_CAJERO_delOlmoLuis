package modelo.tabla;

public class CuentasFila {
	private int id;
	private String numero;
	private String iban;
	private float saldo;
	private boolean seleccionable;

	public CuentasFila(int id, String numero, String iban, float saldo,boolean seleccionable) {
		super();
		this.id = id;
		this.numero = numero;
		this.iban = iban;
		this.saldo = saldo;
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
