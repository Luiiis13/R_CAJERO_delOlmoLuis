package modelo.tabla;

/***
 * Clase que sirve como modelo de cuenta DTO para poder hacer las tablas de la
 * vista y asi no modificar los verdaderos modelos que sirven para la base de
 * datos
 * 
 * @author Luis
 *
 */
public class CuentasFila {
	private int id;
	private String numero;
	private String iban;
	private float saldo;
	private boolean seleccionable;
	private int idUsuario;

	public CuentasFila(int id, String numero, String iban, float saldo, boolean seleccionable, int idUsuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.iban = iban;
		this.saldo = saldo;
		this.seleccionable = seleccionable;
		this.idUsuario = idUsuario;
	}

	public String getNumero() {
		return numero;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
