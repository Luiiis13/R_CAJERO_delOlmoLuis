package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.BonobusDTO;
import modelo.dto.TelefonoDTO;

/***
 * Clase que sirve para sacar/eliminar/insertar datos de telefono en la base de
 * datos
 * 
 * @author Luis
 *
 */
public class TelefonoDAO {
	/***
	 * Metodo que sirve para insertar un telefono en la base de datos
	 * 
	 * @param nuevoTelefono parametro que es el telefono nuevo que deseamos insertar
	 * @throws Exception
	 */
	public void insertarTelefono(TelefonoDTO nuevoTelefono) throws Exception {
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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
	}

	/***
	 * Metodo que sirve para sacar todos los telefonos de la base de datos
	 * 
	 * @return devuelve un array con todos los telefonos
	 */
	public ArrayList<TelefonoDTO> obtenerTelefonos() {
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

	/***
	 * Metodo que sirve para sacar un determinado telefono de la base de datos
	 * 
	 * @param numeroTelefono parametro entero que identificara el telefono que
	 *                       nosotros queremos
	 * @return
	 */
	public TelefonoDTO obtenerTelefono(int numeroTelefono) {
		TelefonoDTO telefono = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM telefono WHERE numero=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, numeroTelefono);
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

	/***
	 * Metodo que sirve para sacar un determinado telefono de la base de datos con
	 * la tarjeta
	 * 
	 * @param idTarjeta parametro entero que identificara el telefono que nosotros
	 *                  queremos
	 * @return
	 */
	public TelefonoDTO obtenerTelefonoDadoTarjeta(int idTarjeta) {
		TelefonoDTO telefono = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM telefono WHERE id_tarjeta_asociada=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, idTarjeta);
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

	/***
	 * Metodo que sirve para eliminar un determinado telefono de la base de datos
	 * 
	 * @param id variable int que determinara el telefono que queremos
	 * @return devolvera un booleano
	 * @throws Exception
	 */
	public boolean eliminarTelefono(int id) throws Exception {
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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return eliminado;
	}

	/***
	 * Metodo por el cual actualizaremos un telefono de la base de datos
	 * 
	 * @param nuevoTelefono parametro el cual es un objeto de tipo telefono que sustituira al que deseamos actualizar
	 * @return
	 * @throws Exception
	 */
	public boolean actualizarTelefono(TelefonoDTO nuevoTelefono) throws Exception {
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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return actualizado;

	}
}
