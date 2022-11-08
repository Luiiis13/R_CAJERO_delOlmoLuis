package vista;

import java.util.ArrayList;

import modelo.dao.RolDAO;
import modelo.dto.RolDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

RolDAO roldao=new RolDAO();
ArrayList<RolDTO> ejemplo = roldao.obtenerRoles();
for(int i = 0; i<ejemplo.size();i++) {
	RolDTO rol = ejemplo.get(i);
	System.out.println(" id "+rol.getId()+ " nombre "+rol.getNombre()+" Descricion "+rol.getDescripcion());
}

	}

}
