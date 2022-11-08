package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conectar {

	private Connection connect = null;

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String bbdd = "progamacion";
	final private String user = "root";
	final private String passwd = "l13032003";

	public Conectar() {
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd + "?serverTimezone=UTC", user,passwd);

		} catch (Exception e) {
			System.out.println("Error al crear la conexion: " + e.getLocalizedMessage());
		}
	}

	public void cerrarConexion() {
		try {
			if (this.connect != null) {
				this.connect.close();
			}
		} catch (Exception e) {
			System.out.println("Error al cerrar las conexiones: " + e.getLocalizedMessage());
		}
	}
}
