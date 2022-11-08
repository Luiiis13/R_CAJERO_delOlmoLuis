package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conectar;
import modelo.dto.RolDTO;

public class RolDAO {

	public void insertarRol(RolDTO nuevoRol) {
		Conectar conexion = new Conectar();

		try {
			String query = "INSERT INTO rol(nombre,descripcion) VALUES (?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoRol.getNombre());
			preparedStatement.setString(2, nuevoRol.getDescripcion());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

	}

	public ArrayList<RolDTO> obtenerRoles() {
		ArrayList<RolDTO> roles = new ArrayList<>();

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM rol ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);

			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String descripcion = resultado.getString("descripcion");
				RolDTO rol = new RolDTO(id, nombre, descripcion);

				roles.add(rol);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

		return roles;
	}
}
