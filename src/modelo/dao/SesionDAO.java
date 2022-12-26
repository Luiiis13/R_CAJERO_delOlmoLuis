package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conectar;
import modelo.dto.SesionDTO;

public class SesionDAO {

	public SesionDTO verificarSesion(int numeroTarjeta) {
		
		SesionDTO sesionDTO = new SesionDTO();
		sesionDTO.setNumeroTarjeta(numeroTarjeta);
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT id,pin,fecha_expiracion FROM tarjeta WHERE numero=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, numeroTarjeta);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				sesionDTO.setId(resultado.getInt("id")); 
				sesionDTO.setPin(resultado.getInt("pin")); 
				sesionDTO.setFechaExpiracion(resultado.getDate("fecha_expiracion")); 

			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return sesionDTO;
	}
}
