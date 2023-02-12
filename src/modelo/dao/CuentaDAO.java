package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.CuentaDTO;
/***
 * Clase que sirve para sacar/eliminar/insertar datos de Cuenta en la base de datos
 * @author Luis
 *
 */
public class CuentaDAO {
	/***
	 * Metodo que sirve para insertar un cuenta en la base de datos 
	 * @param nuevacuenta parametro que es la cuenta nuevo que deseamos insertar 
	 * @throws Exception 
	 */
	public void insertarCuenta(CuentaDTO nuevacuenta) throws Exception {
		Conectar conexion = new Conectar();
		try {
			String query = "INSERT INTO Cuenta(numero,iban,saldo,id_usuario) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevacuenta.getNumero());
			preparedStatement.setString(2, nuevacuenta.getIban());
			preparedStatement.setFloat(3, nuevacuenta.getSaldo());
			preparedStatement.setInt(4, nuevacuenta.getId_usuario());
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
	 * Metodo que sirve para sacar todas las cuentas de la base de datos 
	 * @return devuelve un array con todos las cuentas 
	 */
	public ArrayList<CuentaDTO> obtenerCuentas() {
		ArrayList<CuentaDTO> cuentas = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cuenta";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				String numero = resultado.getString("numero");
				String iban = resultado.getString("iban");
				float saldo = resultado.getFloat("saldo");
				int idUsuario = resultado.getInt("id_usuario");
				CuentaDTO cuenta = new CuentaDTO(id, numero, iban, saldo, idUsuario);
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
	/***
	 * Metodo que sirve para sacar una determinada cuenta de la base de datos
	 * 
	 * @param id parametro entero que identificara la cuenta que
	 *                       nosotros queremos
	 * @return
	 */
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
				String numero = resultado.getString("numero");
				String iban = resultado.getString("iban");
				float saldo = resultado.getFloat("saldo");
				int idUsuario = resultado.getInt("id_usuario");
				cuenta = new CuentaDTO(idCuenta, numero, iban, saldo, idUsuario);
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

	/***
	 * Metodo que sirve para eliminar una determinada cuenta de la base de datos 
	 * @param id variable int que determinara la cuenta que queremos 
	 * @return devolvera un booleano 
	 * @throws Exception
	 */
	public boolean eliminarCuenta(int id) throws Exception {
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
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return eliminado;
	}
	/***
	 * Metodo por el cual actualizaremos una cuenta de la base de datos
	 * @param nuevaCuenta parametro el cual es un objeto de tipo cuenta que sustituira a la que deseamos actualizar
	 * @return
	 * @throws Exception
	 */
	public boolean actualizarCuenta(CuentaDTO nuevaCuenta) throws Exception {
		boolean actualizado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE Cuenta SET numero=?,iban=?,saldo=?,id_usuario=? WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevaCuenta.getNumero());
			preparedStatement.setString(2, nuevaCuenta.getIban());
			preparedStatement.setFloat(3, nuevaCuenta.getSaldo());
			preparedStatement.setInt(4, nuevaCuenta.getId_usuario());
			preparedStatement.setInt(5, nuevaCuenta.getId());
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
	/***
	 * Metodo que sirve para sacar una determinada cuenta de la base de datos
	 * 
	 * @param numeroCuenta parametro String que identificara la cuenta que
	 *                       nosotros queremos
	 * @return
	 */
	public CuentaDTO obtenerCuentaDadoNumero(String numeroCuenta) {
		CuentaDTO cuenta = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Cuenta WHERE numero=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, numeroCuenta);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idCuenta = resultado.getInt("id");
				String numero = resultado.getString("numero");
				String iban = resultado.getString("iban");
				float saldo = resultado.getFloat("saldo");
				int idUsuario = resultado.getInt("id_usuario");
				cuenta = new CuentaDTO(idCuenta, numero, iban, saldo, idUsuario);
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
}
