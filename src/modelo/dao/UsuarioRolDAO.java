package modelo.dao;

import java.sql.PreparedStatement;

import modelo.Conectar;
import modelo.dto.UsuarioRolDTO;

public class UsuarioRolDAO {
	public void insertarUsuarioRol(UsuarioRolDTO nuevoUsuarioRol) {
		Conectar conexion = new Conectar();
		try {
			String query = "INSERT INTO usuario_rol (id_usuario,id_rol) VALUES(?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, nuevoUsuarioRol.getId_usuario());
			preparedStatement.setInt(2, nuevoUsuarioRol.getId_rol());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conexion.cerrarConexion();
		}
	}
	public boolean eliminarUsuarioRol(int id) {
		boolean eliminado = false;
		
		Conectar conexion = new Conectar();
		try {
			String query = "DELETE * FROM usuario_rol WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			eliminado= true;
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		finally {
			conexion.cerrarConexion();
		}
		return eliminado;
		
	}
	
	public boolean actualizarUsuarioRol(UsuarioRolDTO actualizarUsuarioRol) {
		
		boolean actualizado= false;
		Conectar conexion = new Conectar();
		try {
			String query="UPDATE usuario_rol SET id_usuario=?,id_rol=? WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1,actualizarUsuarioRol.getId_usuario());
			preparedStatement.setInt(2,actualizarUsuarioRol.getId_rol());
			preparedStatement.setInt(3,actualizarUsuarioRol.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conexion.cerrarConexion();
		}
		return actualizado;
	}
	
}
