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
			String query = "INSERT INTO Movimiento(tipo,fecha_del_movimiento,cuenta_asociada) VALUES(?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			
			preparedStatement.setString(1, nuevoMovimiento.getTipo());
			preparedStatement.setDate(2, nuevoMovimiento.getFechaDelMovimiento());
			preparedStatement.setInt(3, nuevoMovimiento.getCuentaAsociada());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
	}

	
	public ArrayList<MovimientoDTO> obtenerMovimiento(int idCuenta) {
		ArrayList<MovimientoDTO> Movimientos = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Movimiento WHERE cuenta_asociada=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, idCuenta);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int idMovimientos = resultado.getInt("id");
				String tipo = resultado.getString("tipo");
				Date fechaDelMovimiento = resultado.getDate("fecha_del_movimiento");
				int cuentaAsociada = resultado.getInt("cuenta_asociada");
				MovimientoDTO Movimiento = new MovimientoDTO(idMovimientos,fechaDelMovimiento,tipo,cuentaAsociada);
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

	
}
