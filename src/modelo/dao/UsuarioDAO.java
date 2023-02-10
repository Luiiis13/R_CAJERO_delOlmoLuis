package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import modelo.Conectar;
import modelo.dto.UsuarioDTO;
/***
 * Clase que sirve para sacar/eliminar/insertar datos de usuario en la base de datos
 * @author Luis
 *
 */
public class UsuarioDAO {
/***
 * Metodo que sirve para insertar un usuario en la base de datos 
 * @param nuevoUsuario parametro que es el usuario nuevo que deseamos insertar 
 * @throws Exception 
 */
	public void insertarUsuario(UsuarioDTO nuevoUsuario) throws Exception {
		Conectar conexion = new Conectar();
		try {
			String query = "INSERT INTO usuario(nombre,dni,primer_apellido,es_admin,contraseña) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoUsuario.getNombre());
			preparedStatement.setString(2, nuevoUsuario.getDni());
			preparedStatement.setString(3, nuevoUsuario.getPrimerApellido());
			preparedStatement.setBoolean(4, nuevoUsuario.getEsAdmin());
			preparedStatement.setString(5, nuevoUsuario.getContraseña());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			// TO DO ver como devolver el id generado en base de datos 
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
	}
/***
 * Metodo que sirve para sacar todos los usuarios de la base de datos 
 * @return devuelve un array con todos los usuarios 
 */
	public ArrayList<UsuarioDTO> obtenerUsuarios() {
		ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM Usuario";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {

				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String dni = resultado.getString("dni");
				String primerApellido = resultado.getString("primer_apellido");
				boolean isAdmin = resultado.getBoolean("es_admin");
				String contraseña = resultado.getString("contraseña");
				UsuarioDTO usuario = new UsuarioDTO(id, nombre, dni, primerApellido, isAdmin, contraseña);
				usuarios.add(usuario);
			}
			resultado.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return usuarios;
	}
/***
 * Metodo que sirve para sacar un determinado usuario de la base de datos 
 * @param id parametro entero que identificara el usuario que nosotros queremos 
 * @return
 */
	public UsuarioDTO obtenerUsuario(int id) {
		UsuarioDTO usuario = null;
		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM usuario WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idResult = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String dni = resultado.getString("dni");
				String primerApellido = resultado.getString("primer_apellido");
				boolean isAdmin = resultado.getBoolean("es_admin");
				String contraseña = resultado.getString("contraseña");
				usuario = new UsuarioDTO(idResult, nombre, dni, primerApellido, isAdmin, contraseña);
			}
			resultado.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return usuario;
	}
/***
 * Metodo que sirve para eliminar un determinado usuario de la base de datos 
 * @param id variable int que determinara el usuario que queremos 
 * @return devolvera un booleano 
 * @throws Exception
 */
	public boolean eliminarUsuario(int id) throws Exception {
		boolean eliminar = false;
		Conectar conexion = new Conectar();
		try {
			String query = "DELETE  FROM usuario WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			eliminar = true;
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			conexion.cerrarConexion();
		}
		return eliminar;
	}
/***
 * Metodo por el cual actualizaremos un usuario de la base de datos
 * @param nuevoUsuario
 * @return
 * @throws Exception
 */
	public boolean actualizarUsuario(UsuarioDTO nuevoUsuario) throws Exception {
		boolean actualizado = false;
		Conectar conexion = new Conectar();
		try {
			String query = "UPDATE Usuario SET nombre=? ,dni=?,primer_apellido=?,es_admin=?,contraseña=? WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoUsuario.getNombre());
			preparedStatement.setString(2, nuevoUsuario.getDni());
			preparedStatement.setString(3, nuevoUsuario.getPrimerApellido());
			preparedStatement.setBoolean(4, nuevoUsuario.getEsAdmin());
			preparedStatement.setString(5, nuevoUsuario.getContraseña());
			preparedStatement.setInt(6, nuevoUsuario.getId());
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
