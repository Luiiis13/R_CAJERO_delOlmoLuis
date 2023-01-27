package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.CajeroDTO;;

public class CajeroDAO {
	public void insertarCajero(CajeroDTO nuevoCajero) {
		Conectar conexion = new Conectar();

		try {
			String query = "INSERT INTO Cajero(ubicacion) VALUES (?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoCajero.getUbicacion());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
	}

	public ArrayList<CajeroDTO> obtenerCajeros() {
		ArrayList<CajeroDTO> cajeros = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cajero ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				String ubicacion = resultado.getString("ubicacion");
				CajeroDTO cajero = new CajeroDTO(id, ubicacion);
				cajeros.add(cajero);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cajeros;
	}

	public CajeroDTO obtenerCajero(int id) {
		CajeroDTO cajero = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cajero WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idCajero = resultado.getInt("id");
				String ubicacion = resultado.getString("ubicacion");
				cajero = new CajeroDTO(id, ubicacion);
			}
			resultado.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cajero;
	}

	public boolean eliminarCajero(int id) {
		boolean eliminado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "DELETE From Cajero WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			eliminado = true;
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return eliminado;
	}

	public boolean actualizarCajero(CajeroDTO nuevoCajero) {

		boolean actualizado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE Cajero SET ubicacion=? WHERE id=? ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoCajero.getUbicacion());
			preparedStatement.setInt(2, nuevoCajero.getId());
			preparedStatement.executeUpdate();
			actualizado = true;
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return actualizado;

	}
}
