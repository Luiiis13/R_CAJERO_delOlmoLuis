package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/***
 * Clase que sirve para establecer la conexion con la determinada base de datos 
 * @author Luis
 *
 */
public class Conectar {
	private Connection connect = null;
	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String bbdd = "progamacion";
	final private String user = "root";
	final private String passwd = "l13032003";
/***
 * Constructor para establecer la conexion en la base de datos 
 */
	public Conectar() {
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd + "?serverTimezone=UTC", user,passwd);

		} catch (Exception e) {
			System.out.println("Error al crear la conexión: " + e.getLocalizedMessage());
			}
		}
/***
 * Metodo para cerrar la conexion con la base de datos 
 */
	public void cerrarConexion() {
		try {
			if (this.connect != null) {
				this.connect.close();
			}
		} catch (Exception e) {
			System.out.println("Error al cerrar las conexiones: " + e.getLocalizedMessage());
			}
		}
	
	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	
}
