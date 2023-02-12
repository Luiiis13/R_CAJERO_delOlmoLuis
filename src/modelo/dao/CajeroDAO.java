package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.CajeroDTO;;
/***
 * Clase que sirve para sacar/eliminar/insertar datos de cajero en la base de datos
 * @author Luis
 *
 */
public class CajeroDAO {
	/***
	 * Metodo que sirve para insertar un cajero en la base de datos 
	 * @param nuevoCajero parametro que es el cajero nuevo que deseamos insertar 
	 * @throws Exception 
	 */
	public void insertarCajero(CajeroDTO nuevoCajero) throws Exception {
		Conectar conexion = new Conectar();

		try {
			String query = "INSERT INTO Cajero(ubicacion) VALUES (?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoCajero.getUbicacion());
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
	 * Metodo que sirve para sacar todas los cajeros de la base de datos 
	 * @return devuelve un array con todos los cajeros 
	 */
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
	/***
	 * Metodo que sirve para sacar un determinado cajero de la base de datos
	 * 
	 * @param id parametro entero que identificara el cajero que
	 *                       nosotros queremos
	 * @return
	 */
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
	/***
	 * Metodo que sirve para eliminar un determinado cajero de la base de datos 
	 * @param id variable int que determinara el cajero que queremos 
	 * @return devolvera un booleano 
	 * @throws Exception
	 */
	public boolean eliminarCajero(int id) throws Exception {
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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return eliminado;
	}
	/***
	 * Metodo por el cual actualizaremos un cajero de la base de datos
	 * @param nuevoCajero parametro el cual es un objeto de tipo cajero que sustituira a la que deseamos actualizar
	 * @return
	 * @throws Exception
	 */
	public boolean actualizarCajero(CajeroDTO nuevoCajero) throws Exception {

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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return actualizado;

	}
}
