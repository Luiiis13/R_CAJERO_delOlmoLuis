package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.CuentaDTO;

public class CuentaDAO {
	public void insertarCuenta(CuentaDTO nuevacuenta) {
		Conectar conexion = new Conectar();

		try {
			String query = "INSERT INTO Cuenta(numero,iban,saldo,tarjeta_asociada,id_usuario) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevacuenta.getNumero());
			preparedStatement.setString(2, nuevacuenta.getIban());
			preparedStatement.setFloat(3, nuevacuenta.getSaldo());
			preparedStatement.setInt(4, nuevacuenta.getTarjetaAsociada());
			preparedStatement.setInt(5, nuevacuenta.getId_usuario());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

	}

	public ArrayList<CuentaDTO> obtenerCuentas() {

		ArrayList<CuentaDTO> cuentas = new ArrayList<>();

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cuenta";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				int numero = resultado.getInt("numero");
				String iban = resultado.getString("iban");
				float saldo = resultado.getFloat("saldo");
				int tarjetaAsociada = resultado.getInt("tarjeta_asociada");
				int idUsuario = resultado.getInt("id_usuario");
				CuentaDTO cuenta = new CuentaDTO(id, numero, iban, saldo, tarjetaAsociada, idUsuario);

				cuentas.add(cuenta);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cuentas;

	}

	public CuentaDTO obtenerCuenta(int id) {

		CuentaDTO cuenta = null;

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cuenta WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idCuenta = resultado.getInt("id");
				int numero = resultado.getInt("numero");
				String iban = resultado.getString("iban");
				float saldo = resultado.getFloat("saldo");
				int tarjetaAsociada = resultado.getInt("tarjeta_asociada");
				int idUsuario = resultado.getInt("id_usuario");
				cuenta = new CuentaDTO(idCuenta, numero, iban, saldo, tarjetaAsociada, idUsuario);

			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cuenta;

	}

	public CuentaDTO obtenerCuentaDadoTarjeta(int idTarjeta) {

		CuentaDTO cuenta = null;

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cuenta WHERE tarjeta_asociada=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, idTarjeta);

			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idCuenta = resultado.getInt("id");
				int numero = resultado.getInt("numero");
				String iban = resultado.getString("iban");
				float saldo = resultado.getFloat("saldo");
				int tarjetaAsociada = resultado.getInt("tarjeta_asociada");
				int idUsuario = resultado.getInt("id_usuario");
				cuenta = new CuentaDTO(idCuenta, numero, iban, saldo, tarjetaAsociada, idUsuario);

			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return cuenta;

	}

	public boolean eliminarCuenta(int id) {
		boolean eliminado = false;

		Conectar conexion = new Conectar();

		try {
			String query = "DELETE From Cuenta WHERE id=?";
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

	public boolean actualizarCuenta(CuentaDTO nuevaCuenta) {

		boolean actualizado = false;

		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE Cuenta SET numero=?,iban=?,saldo=?,tarjeta_asociada=?,id_usuario=? WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevaCuenta.getNumero());
			preparedStatement.setString(2, nuevaCuenta.getIban());
			preparedStatement.setFloat(3, nuevaCuenta.getSaldo());
			preparedStatement.setInt(4, nuevaCuenta.getTarjetaAsociada());
			preparedStatement.setInt(5, nuevaCuenta.getId_usuario());
			preparedStatement.setInt(6, nuevaCuenta.getId());
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
