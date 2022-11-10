package modelo.dto;

public class usuario_rolDTO {
	private int id;
	private int id_usuario;
	private int id_rol;

	public usuario_rolDTO(int id, int id_usuario, int id_rol) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.id_rol = id_rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

}
