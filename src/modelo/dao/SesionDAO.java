package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conectar;
import modelo.dto.CajeroDTO;
import modelo.dto.SesionDTO;

public class SesionDAO {

	public int verificarSesion(SesionDTO nuevaSesion) {
		int idTarjeta = -1;

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT id FROM tarjeta WHERE numero=? and pin=?  and date(fecha_expiracion)>=curdate()";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevaSesion.getNumeroTarjeta());
			preparedStatement.setInt(2, nuevaSesion.getPin());
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				idTarjeta = resultado.getInt("id");

			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

		return idTarjeta;
	}
}
