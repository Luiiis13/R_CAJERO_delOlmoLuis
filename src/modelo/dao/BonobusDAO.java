package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conectar;
import modelo.dto.BonobusDTO;

public class BonobusDAO {
public void insertarbonobus(BonobusDTO nuevoBonobus) {
	Conectar conexion = new Conectar();

	try {
		String query = "INSERT INTO Bonobus(saldo,id_cuenta) VALUES (?,?)";
		PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
		preparedStatement.setFloat(1, nuevoBonobus.getSaldo());
		preparedStatement.setInt(2, nuevoBonobus.getIdCuenta());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		conexion.cerrarConexion();
		}
	}
	
public ArrayList<BonobusDTO> obtenerBonobuses() {
	ArrayList<BonobusDTO> bonobuses = new ArrayList<>();
	Conectar conexion = new Conectar();
	try {
		String query = "SELECT * FROM Bonobus ";
		PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);

		ResultSet resultado = preparedStatement.executeQuery();
		while (resultado.next() == true) {
			int id = resultado.getInt("id");
			Float saldo = resultado.getFloat("saldo");
			int idCuenta = resultado.getInt("id_cuenta");

			BonobusDTO bonobus = new BonobusDTO(id, saldo,idCuenta);
			bonobuses.add(bonobus);
		}
		resultado.close();
		preparedStatement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		conexion.cerrarConexion();
	}
	return bonobuses;
}

public BonobusDTO obtenerBonobus(int id) {
	BonobusDTO bonobus = null;
	Conectar conexion = new Conectar();
	try {
		String query = "SELECT * FROM Bonobus WHERE id=?";
		PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultado = preparedStatement.executeQuery();
		if (resultado.next() == true) {
			int idBonobus = resultado.getInt("id");
			Float saldo = resultado.getFloat("saldo");
			int idCuenta = resultado.getInt("id_cuenta");
			bonobus = new BonobusDTO(idBonobus, saldo,idCuenta);
		}
		resultado.close();
		preparedStatement.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		conexion.cerrarConexion();
	}
	return bonobus;
}

public boolean eliminarBonobus(int id) {
	boolean eliminado = false;
	Conectar conexion = new Conectar();
	try {
		String query = "DELETE From Bonobus WHERE id=?";
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

public boolean actualizarBonobus(BonobusDTO nuevoBonobus) {

	boolean actualizado = false;
	Conectar conexion = new Conectar();
	try {
		String query = "UPDATE Bonobus SET saldo=?, id_cuenta=? WHERE id=? ";
		PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
		preparedStatement.setFloat(1, nuevoBonobus.getSaldo());
		preparedStatement.setInt(2, nuevoBonobus.getIdCuenta());
		preparedStatement.setInt(3, nuevoBonobus.getId());

		preparedStatement.executeUpdate();
		actualizado = true;
		preparedStatement.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		conexion.cerrarConexion();
	}
	return actualizado;

}

}
