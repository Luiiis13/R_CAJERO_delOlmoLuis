package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Conectar;
import modelo.dto.RolDTO;

public class RolDAO {

	public void insertarRol(RolDTO nuevoRol) {
		Conectar conexion = new Conectar();

		try {
			String query = "INSERT INTO rol(nombre,descripcion) VALUES (?,?)";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1, nuevoRol.getNombre());
			preparedStatement.setString(2, nuevoRol.getDescripcion());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

	}

	public ArrayList<RolDTO> obtenerRoles() {
		ArrayList<RolDTO> roles = new ArrayList<>();

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM rol ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);

			ResultSet resultado = preparedStatement.executeQuery();
			while (resultado.next() == true) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String descripcion = resultado.getString("descripcion");
				RolDTO rol = new RolDTO(id, nombre, descripcion);

				roles.add(rol);
			}
			resultado.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

		return roles;
	}

	public RolDTO obtenerRol(int id) {
		RolDTO rol = null;

		Conectar conexion = new Conectar();
		try {
			String query = "SELECT * FROM rol WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
			if (resultado.next() == true) {
				int idResult = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String descripcion = resultado.getString("descripcion");
				rol = new RolDTO(idResult, nombre, descripcion);

			}
			resultado.close();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return rol;
	}
	
	
	public boolean eliminarRol(int id) {
		boolean eliminado = false;
		
		Conectar conexion = new Conectar();
		
		try {
			String query="DELETE From rol WHERE id=?";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			eliminado=true;
			
			preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}finally {
			conexion.cerrarConexion();
		}
		
		return eliminado;
		
	}
	
	
	public boolean actualizarRol(RolDTO nuevoRol) {
		
		boolean actualizado=false;
		
		Conectar conexion=new Conectar();
		try {
			String query="UPDATE rol SET nombre=? ,descripcion=? WHERE id=? ";
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1,nuevoRol.getNombre());
			preparedStatement.setString(2, nuevoRol.getDescripcion());
			preparedStatement.setInt(3, nuevoRol.getId());
			preparedStatement.executeUpdate();
			actualizado=true;
		
		preparedStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conexion.cerrarConexion();
		}
		
		return actualizado;
		
		
		
	}

}
