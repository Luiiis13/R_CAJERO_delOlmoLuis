package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.MovimientoDTO;

public class MovimientoDAO {
	public void insertarMovimiento(MovimientoDTO nuevoMovimiento) {
		Conectar conexion = new Conectar();
		try {
			String query = "INSERT INTO Movimiento(id_cuenta_origen,id_cuenta_destino,cantidad,fecha_del_movimiento) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevoMovimiento.getIdCuentaOrigen());
			preparedStatement.setInt(2, nuevoMovimiento.getIdCuentaDestino());
			preparedStatement.setFloat(3, nuevoMovimiento.getCantidad());
			preparedStatement.setDate(4, nuevoMovimiento.getFechaDelMovimiento());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
	}

	public ArrayList<MovimientoDTO> obtenerMovimientos() {
		ArrayList<MovimientoDTO> Movimientos = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Movimiento";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				int idCuentaOrigen = resultado.getInt("id_cuenta_origen");
				int idCuentaDestino = resultado.getInt("id_cuenta_destino");
				float cantidad = resultado.getFloat("cantidad");
				Date fechaDelMovimiento = resultado.getDate("fecha_del_movimiento");
				MovimientoDTO Movimiento = new MovimientoDTO(id, idCuentaOrigen, idCuentaDestino, cantidad,
						fechaDelMovimiento);
				Movimientos.add(Movimiento);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return Movimientos;
	}

	public ArrayList<MovimientoDTO> obtenerMovimiento(int id) {
		ArrayList<MovimientoDTO> Movimientos = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Movimiento WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int idMovimientos = resultado.getInt("id");
				int idCuentaOrigen = resultado.getInt("id_cuenta_origen");
				int idCuentaDestino = resultado.getInt("id_cuenta_destino");
				float cantidad = resultado.getFloat("cantidad");
				Date fechaDelMovimiento = resultado.getDate("fecha_del_movimiento");
				MovimientoDTO Movimiento = new MovimientoDTO(idMovimientos, idCuentaOrigen, idCuentaDestino, cantidad,
						fechaDelMovimiento);
				Movimientos.add(Movimiento);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return Movimientos;
	}

	public boolean eliminarMovimiento(int id) {
		boolean eliminado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "DELETE From Movimiento WHERE id=?";
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

	public boolean actualizarMovimiento(MovimientoDTO nuevoMovimiento) {
		boolean actualizado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE Movimiento SET id_cuenta_origen=?,id_cuenta_destino=?,cantidad=?,fecha_del_movimiento=? WHERE id=? ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevoMovimiento.getIdCuentaOrigen());
			preparedStatement.setInt(2, nuevoMovimiento.getIdCuentaDestino());
			preparedStatement.setFloat(3, nuevoMovimiento.getCantidad());
			preparedStatement.setDate(4, nuevoMovimiento.getFechaDelMovimiento());
			preparedStatement.setInt(5, nuevoMovimiento.getId());
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
