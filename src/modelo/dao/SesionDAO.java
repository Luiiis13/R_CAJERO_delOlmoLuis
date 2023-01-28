package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conectar;
import modelo.dto.SesionAdministradorDTO;
import modelo.dto.SesionUsuarioDTO;

public class SesionDAO {

	public SesionUsuarioDTO verificarSesion(String numeroTarjeta) {

		SesionUsuarioDTO sesionUsuarioDTO = new SesionUsuarioDTO();
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
