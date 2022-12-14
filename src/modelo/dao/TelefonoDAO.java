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
			String query = "INSERT INTO telefono(numero,saldo,id_cuenta) VALUES (?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setFloat(1, nuevoTelefono.getNumero());
			preparedStatement.setFloat(2, nuevoTelefono.getSaldo());
			preparedStatement.setInt(3, nuevoTelefono.getIdCuenta());
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
				int idCuentaDB = resultado.getInt("id_cuenta");

				TelefonoDTO telefono = new TelefonoDTO(idDB, numeroDB, saldoDB, idCuentaDB);
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

	public TelefonoDTO obtenerTelefonos(int idCuenta) {
		TelefonoDTO telefono = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM telefono WHERE id_cuenta=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, idCuenta);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idTelefonoDB = resultado.getInt("id");
				int numeroDB = resultado.getInt("numero");
				float saldoDB = resultado.getFloat("saldo");
				int idCuentaDB = resultado.getInt("id_cuenta");
				telefono = new TelefonoDTO(idTelefonoDB, numeroDB, saldoDB, idCuentaDB);
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
			String query = "UPDATE telefono SET numero=?,saldo=?, id_cuenta=? WHERE id=? ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevoTelefono.getIdCuenta());
			preparedStatement.setFloat(2, nuevoTelefono.getSaldo());
			preparedStatement.setInt(3, nuevoTelefono.getIdCuenta());
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
