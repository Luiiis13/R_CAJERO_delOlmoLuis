package vista;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.dto.UsuarioDTO;
import modelo.tabla.UsuarioFila;

public class ModeloTablaUsuarios extends AbstractTableModel implements TableModel {
	private static int Columnas = 6;
	private ArrayList<UsuarioFila> datos;

	public ModeloTablaUsuarios() {
		this.datos = new ArrayList<>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.datos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Columnas;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Id";
		case 1:
			return "Nombre";
		case 2:
			return "Dni";
		case 3:
			return "Primer apellido";
		case 4:
			return "Administrador";
		case 5:
			return "Seleccionable";

		default:
			return null;
		}

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class; // tambien esta el Float.class, Double.class y Boolean.class
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return Boolean.class;
		case 5:
			return Boolean.class;

		default:
			return Object.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 5) {
			return true;
		}
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UsuarioFila usuario = this.datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return usuario.getId();
		case 1:
			return usuario.getNombre();
		case 2:
			return usuario.getDni();
		case 3:
			return usuario.getPrimerApellido();
		case 4:
			return usuario.getIsAdmin();
		case 5:
			return usuario.isSeleccionable();

		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		UsuarioFila usuario = this.datos.get(rowIndex);

		switch (columnIndex) {
		case 1:
			usuario.setNombre((String) value);// Empiezan en case 1 porque el id no le edito
			break;
		case 2:
			usuario.setDni((String) value);
			break;
		case 3:
			usuario.setPrimerApellido((String) value);
			break;
		case 4:
			usuario.setIsAdmin((boolean) value);
			break;
		case 5:
			usuario.setSeleccionable((boolean)value);			
			break;
		default:
			break;
		}
		// TO DO actualizar en base de datos
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	public void agregarDatosDeTabla(ArrayList<UsuarioDTO> usuariosBD) {
		for (int i = 0; i < usuariosBD.size(); i++) {
			UsuarioDTO usuarioDTO = usuariosBD.get(i);
			UsuarioFila datosFila = new UsuarioFila(usuarioDTO.getId(), usuarioDTO.getNombre(), usuarioDTO.getDni(),
					usuarioDTO.getPrimerApellido(), usuarioDTO.getEsAdmin(), false);
			this.datos.add(datosFila);
		}
	}
}
