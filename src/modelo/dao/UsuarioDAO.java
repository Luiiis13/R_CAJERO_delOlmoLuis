package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import modelo.Conectar;
import modelo.dto.UsuarioDTO;

public class UsuarioDAO {

	public void insertarUsuario(UsuarioDTO nuevoUsuario) {
		Conectar conexion= new Conectar(); 
		try {
			String query ="INSERT INTO usuario(nombre,edad,primer_apellido) VALUES(?,?,?)";
			PreparedStatement preparedStatement=conexion.getConnect().prepareStatement(query);
			preparedStatement.setString(1,nuevoUsuario.getNombre());
			preparedStatement.setInt(2, nuevoUsuario.getEdad());
			preparedStatement.setString(3, nuevoUsuario.getPrimerApellido());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			conexion.cerrarConexion();
		}
		
		}
		public ArrayList<UsuarioDTO>obtenerUsuarios(){
			ArrayList<UsuarioDTO>usuarios=new ArrayList<>();
			
			Conectar conexion=new Conectar();
			try {
				
				String query="SELECT * FROM Usuario";
				PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
				ResultSet resultado = preparedStatement.executeQuery();
				while(resultado.next()==true) {
					
					int id = resultado.getInt("id");
					String nombre=resultado.getString("nombre");
					int Edad=resultado.getInt("edad");
					String primerApellido=resultado.getString("primer_apellido");
					UsuarioDTO usuario = new UsuarioDTO(id, nombre, Edad, primerApellido);
					usuarios.add(usuario);
				}
				resultado.close();
				preparedStatement.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				conexion.cerrarConexion();
			}
			
			return usuarios;
					
	}

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
					int edad=resultado.getInt("edad");
					String primerApellido = resultado.getString("primer_apellido");
					usuario = new UsuarioDTO(idResult, nombre, edad,primerApellido);

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
		
		public boolean eliminarUsuario(int id) {
			
			boolean eliminar=false;
			
			Conectar conexion = new Conectar();
			
			try {
				String query= "DELETE  FROM usuario WHERE id=?";
				PreparedStatement preparedStatement = conexion.getConnect().prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				eliminar=true;
				preparedStatement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				conexion.cerrarConexion();
			}
			return eliminar;
		}
		
		public boolean actualizarUsuario(UsuarioDTO nuevoUsuario) {
			
			boolean actualizado=false;
			Conectar conexion = new Conectar();
			try {
				String query="UPDATE Usuario SET nombre=? ,edad=?,primer_apellido=? WHERE id=?";
				PreparedStatement preparedStatement=conexion.getConnect().prepareStatement(query);
				preparedStatement.setString(1,nuevoUsuario.getNombre());
				preparedStatement.setInt(2, nuevoUsuario.getEdad());
				preparedStatement.setString(3, nuevoUsuario.getPrimerApellido());
				preparedStatement.setInt(4, nuevoUsuario.getId());
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
