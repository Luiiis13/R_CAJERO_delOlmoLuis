package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conectar;
import modelo.dto.CajeroDTO;
import modelo.dto.SesionDTO;

public class SesionDAO {

	public boolean verificarSesion(SesionDTO nuevaSesion) {
		boolean verificar = false;

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT EXISTS(SELECT * FROM tarjeta WHERE numero=? and pin=?) as valido ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevaSesion.getNumeroTarjeta());
			preparedStatement.setInt(2, nuevaSesion.getPin());
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int valido = resultado.getInt("valido");
				if (valido == 1) {
					verificar = true;
				}
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

		return verificar;
	}
}
