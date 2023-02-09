package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.TarjetaDTO;

public class TarjetaDAO {
	public void insertarTarjeta(TarjetaDTO nuevaTarjeta) throws Exception {
		Conectar conexion = new Conectar();
		try {
			String query = "INSERT INTO Tarjeta(numero,fecha_expiracion,cvv,pin,bloqueado,id_cuenta_asociada) VALUES(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nuevaTarjeta.getNumero());
			preparedStatement.setDate(2, nuevaTarjeta.getFecha_expiracion());
			preparedStatement.setInt(3, nuevaTarjeta.getCvv());
			preparedStatement.setInt(4, nuevaTarjeta.getPin());
			preparedStatement.setBoolean(5, nuevaTarjeta.isBloqueado());
			preparedStatement.setInt(6, nuevaTarjeta.getIdCuentaAsociada());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				nuevaTarjeta.setId(generatedKeys.getInt(1));
			}

			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
	}

	public ArrayList<TarjetaDTO> obtenerTarjetas() {
		ArrayList<TarjetaDTO> tarjetas = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Tarjeta";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				String numero = resultado.getString("numero");
				Date fechaExpiracion = resultado.getDate("fecha_expiracion");
				int cvv = resultado.getInt("cvv");
				int pin = resultado.getInt("pin");
				boolean bloqueado = resultado.getBoolean("bloqueado");
				int idCuentaAsociadaBD = resultado.getInt("id_cuenta_asociada");
				TarjetaDTO tarjeta = new TarjetaDTO(id, numero, fechaExpiracion, cvv, pin, bloqueado,
						idCuentaAsociadaBD);
				tarjetas.add(tarjeta);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return tarjetas;
	}

	public TarjetaDTO obtenerTarjeta(int id) {
		TarjetaDTO tarjeta = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Tarjeta WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idtarjeta = resultado.getInt("id");
				String numero = resultado.getString("numero");
				Date fechaExpiracion = resultado.getDate("fecha_expiracion");
				int cvv = resultado.getInt("cvv");
				int pin = resultado.getInt("pin");
				boolean bloqueado = resultado.getBoolean("bloqueado");
				int idCuentaAsociadaBD = resultado.getInt("id_cuenta_asociada");

				tarjeta = new TarjetaDTO(idtarjeta, numero, fechaExpiracion, cvv, pin, bloqueado, idCuentaAsociadaBD);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return tarjeta;
	}

	public boolean eliminarTarjeta(int id) {
		boolean eliminado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "DELETE From Tarjeta WHERE id=?";
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

	public boolean actualizarTarjeta(TarjetaDTO nuevaTarjeta) {
		boolean actualizado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE Tarjeta SET numero=?,fecha_expiracion=?,cvv=?,pin=?,bloqueado=?,id_cuenta_asociada=? WHERE id=? ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevaTarjeta.getNumero());
			preparedStatement.setDate(2, nuevaTarjeta.getFecha_expiracion());
			preparedStatement.setInt(3, nuevaTarjeta.getCvv());
			preparedStatement.setInt(4, nuevaTarjeta.getPin());
			preparedStatement.setBoolean(5, nuevaTarjeta.isBloqueado());
			preparedStatement.setInt(6, nuevaTarjeta.getIdCuentaAsociada());
			preparedStatement.setInt(7, nuevaTarjeta.getId());
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
