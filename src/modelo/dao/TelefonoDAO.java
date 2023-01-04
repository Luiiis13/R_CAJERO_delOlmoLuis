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
				int id = resultado.getInt("id");
				int numero = resultado.getInt("numero");
				Float saldo = resultado.getFloat("saldo");
				int idCuenta = resultado.getInt("id_cuenta");

				TelefonoDTO telefono = new TelefonoDTO(id, numero, saldo, idCuenta);
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

	public TelefonoDTO obtenerTelefonos(int id) {
		TelefonoDTO telefono = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM telefono WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idTelefono = resultado.getInt("id");
				int numero = resultado.getInt("numero");
				Float saldo = resultado.getFloat("saldo");
				int idCuenta = resultado.getInt("id_cuenta");
				telefono = new TelefonoDTO(idTelefono, numero, saldo, idCuenta);
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
