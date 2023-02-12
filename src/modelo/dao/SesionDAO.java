package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conectar;
import modelo.dto.SesionAdministradorDTO;
import modelo.dto.SesionTarjetaDTO;
/***
	 * Clase que sirve para sacar datos de la base de datos de la sesion que iniciaremos 
	 * @author Luis
	 *
	 */ 
public class SesionDAO {
	/***
	 * Metodo que sirve para verificar la sesion con tarjeta 
	 * @param numeroTarjeta parametro string para verificar la tarjeta
	 * @return
	 */
	public SesionTarjetaDTO verificarSesion(String numeroTarjeta) {

		SesionTarjetaDTO sesionUsuarioDTO = new SesionTarjetaDTO();
		sesionUsuarioDTO.setNumeroTarjeta(numeroTarjeta);
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT id,pin,fecha_expiracion FROM tarjeta WHERE numero=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, numeroTarjeta);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				sesionUsuarioDTO.setId(resultado.getInt("id"));
				sesionUsuarioDTO.setPin(resultado.getInt("pin"));
				sesionUsuarioDTO.setFechaExpiracion(resultado.getDate("fecha_expiracion"));

			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return sesionUsuarioDTO;
	}
/***
 * Metodo que sirve para verificar la sesion del administrador con los determinados datos 
 * @param dni String para sacar el usuario dterminado 
 * @return
 */
	public SesionAdministradorDTO verificarSesionAdministrador(String dni) {
		SesionAdministradorDTO sesionAdministradorDTO = new SesionAdministradorDTO();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT id,nombre,dni,contraseña FROM usuario WHERE dni=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, dni);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				sesionAdministradorDTO.setId(resultado.getInt("id"));
				sesionAdministradorDTO.setNombre(resultado.getString("nombre"));
				sesionAdministradorDTO.setDni(resultado.getString("dni"));
				sesionAdministradorDTO.setContraseña(resultado.getString("contraseña"));
			}
			resultado.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return sesionAdministradorDTO;
	}
}
