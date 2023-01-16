package modelo.dto;

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
