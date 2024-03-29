package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.MovimientoDTO;
/***
 * Clase que sirve para sacar/eliminar/insertar datos de movimiento en la base de datos
 * @author Luis
 *
 */
public class MovimientoDAO {
	/***
	 * Metodo que sirve para insertar un movimiento en la base de datos 
	 * @param nuevoMovimiento parametro que es el movimiento nuevo que deseamos insertar 
	 * @throws Exception 
	 */
	public void insertarMovimiento(MovimientoDTO nuevoMovimiento) throws Exception {
		Conectar conexion = new Conectar();
		try {
			String query = "INSERT INTO Movimiento(tipo,fecha_del_movimiento,id_tarjeta_asociada) VALUES(?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			
			preparedStatement.setString(1, nuevoMovimiento.getTipo());
			preparedStatement.setDate(2, nuevoMovimiento.getFechaDelMovimiento());
			preparedStatement.setInt(3, nuevoMovimiento.getIdTarjetaAsociada());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
	}

	/***
	 * Metodo que sirve para sacar un determinado movimiento de la base de datos
	 * 
	 * @param idTarjetaAsociada parametro entero que identificara el movimiento que
	 *                       nosotros queremos
	 * @return
	 */
	public ArrayList<MovimientoDTO> obtenerMovimiento(int idTarjetaAsociada) {
		ArrayList<MovimientoDTO> Movimientos = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Movimiento WHERE id_tarjeta_asociada=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, idTarjetaAsociada);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int idMovimientos = resultado.getInt("id");
				String tipo = resultado.getString("tipo");
				Date fechaDelMovimiento = resultado.getDate("fecha_del_movimiento");
				int idTarjetaAsociadaBD = resultado.getInt("id_tarjeta_asociada");
				MovimientoDTO Movimiento = new MovimientoDTO(idMovimientos,fechaDelMovimiento,tipo,idTarjetaAsociadaBD);
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
	/***
	 * Metodo que sirve para eliminar un determinado movimiento de la base de datos 
	 * @param id variable int que determinara la tarjeta que queremos 
	 * @return devolvera un booleano 
	 * @throws Exception
	 */
	public boolean eliminarMovimiento(int id) throws Exception {
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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return eliminado;
	}

	
}
