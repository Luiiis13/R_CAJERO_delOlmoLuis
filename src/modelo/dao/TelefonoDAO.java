package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.BonobusDTO;
import modelo.dto.TelefonoDTO;

public class TelefonoDAO {
	public void insertarTelefono(TelefonoDTO nuevoTelefono) {
		Conectar conexion = new Conectar();

		try {
			String query = "INSERT INTO telefono(numero,saldo,id_tarjeta_asociada) VALUES (?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setFloat(1, nuevoTelefono.getNumero());
			preparedStatement.setFloat(2, nuevoTelefono.getSaldo());
			preparedStatement.setInt(3, nuevoTelefono.getIdTarjetaAsociada());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
	}

	public ArrayList<TelefonoDTO> obtenerTelefono() {
		ArrayList<TelefonoDTO> telefonos = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM telefono ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);

			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int idDB = resultado.getInt("id");
				int numeroDB = resultado.getInt("numero");
				float saldoDB = resultado.getFloat("saldo");
				int idTarjetaAsociada = resultado.getInt("id_tarjeta_asociada");

				TelefonoDTO telefono = new TelefonoDTO(idDB, numeroDB, saldoDB, idTarjetaAsociada);
				telefonos.add(telefono);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return telefonos;
	}

	public TelefonoDTO obtenerTelefonos(int idTarjetaAsociada) {
		TelefonoDTO telefono = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM telefono WHERE id_tarjeta_asociada=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, idTarjetaAsociada);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idTelefonoDB = resultado.getInt("id");
				int numeroDB = resultado.getInt("numero");
				float saldoDB = resultado.getFloat("saldo");
				int idTarjetaAsociadaBD = resultado.getInt("id_tarjeta_asociada");
				telefono = new TelefonoDTO(idTelefonoDB, numeroDB, saldoDB, idTarjetaAsociadaBD);
			}
			resultado.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return telefono;
	}

	public boolean eliminarTelefono(int id) {
		boolean eliminado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "DELETE From telefono WHERE id=?";
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

	public boolean actualizarTelefono(TelefonoDTO nuevoTelefono) {

		boolean actualizado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE telefono SET numero=?,saldo=?, id_tarjeta_asociada=? WHERE id=? ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevoTelefono.getIdTarjetaAsociada());
			preparedStatement.setFloat(2, nuevoTelefono.getSaldo());
			preparedStatement.setInt(3, nuevoTelefono.getIdTarjetaAsociada());
			preparedStatement.setInt(4, nuevoTelefono.getId());

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
