package vista;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.dto.CajeroDTO;
import modelo.dto.CuentaDTO;
import modelo.tabla.CajeroFila;
import modelo.tabla.CuentasFila;
/***
 * Clase que implementa la vista de los datos de Cajero en forma de tablas
 * 
 * @author Luis
 *
 */
public class ModeloTablaCajero extends AbstractTableModel implements TableModel{
	public static int columnas=3;
	private ArrayList<CajeroFila> datos;
	
	public ModeloTablaCajero() {
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
		return columnas;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Id";
		case 1:
			return "Ubicacion";
		case 2:
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
			return String.class;
		case 2:
			return Boolean.class;

		default:
			return Object.class;
		}
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 2) {
			return true;
		}
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CajeroFila cajero = this.datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return cajero.getId();
		case 1:
			return cajero.getUbicacion();
		case 2:
			return cajero.isSeleccionable();

		default:
			return null;
		}
	}
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		CajeroFila cajero = this.datos.get(rowIndex);

		switch (columnIndex) {
		case 1:
			cajero.setUbicacion ((String) value);// Empiezan en case 1 porque el id no le edito
			break;
		case 2:
			cajero.setSeleccionable((boolean)value);
			break;
		default:
			break;
		}
		// TO DO actualizar en base de datos
		fireTableCellUpdated(rowIndex, columnIndex);

	}
	public void agregarDatosDeTabla(ArrayList<CajeroDTO> cajeroBD) {
		for (int i = 0; i < cajeroBD.size(); i++) {
			CajeroDTO cajeroDTO = cajeroBD.get(i);
			CajeroFila datosFila = new CajeroFila(cajeroDTO.getId(), cajeroDTO.getUbicacion(), false);
			this.datos.add(datosFila);
		}
	}
	public ArrayList<CajeroFila> getDatos() {
		return datos;
	}
}
