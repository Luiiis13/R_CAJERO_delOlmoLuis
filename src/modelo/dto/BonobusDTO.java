package modelo.dto;

public class BonobusDTO {
	private int id;
	private float saldo;
	private int idCuenta;

	public BonobusDTO(int id, float saldo, int idCuenta) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.idCuenta = idCuenta;
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
