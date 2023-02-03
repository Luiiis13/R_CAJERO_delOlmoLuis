package vista;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.dto.CuentaDTO;
import modelo.tabla.CuentasFila;

public class ModeloTablaCuentas extends AbstractTableModel implements TableModel {
	

	public static int columnas=5;
	private ArrayList<CuentasFila> datos;
	public ModeloTablaCuentas() {
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
			return "Numero";
		case 2:
			return "Iban";
		case 3:
			return "Saldo";
		case 4:
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
			return Float.class;
		case 4:
			return Boolean.class;

		default:
			return Object.class;
		}
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 5) {
			return true;
		}
		return true;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CuentasFila cuenta = this.datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return cuenta.getId();
		case 1:
			return cuenta.getNumero();
		case 2:
			return cuenta.getIban();
		case 3:
			return cuenta.getSaldo();
		case 4:
			return cuenta.isSeleccionable();

		default:
			return null;
		}
	}

	

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		CuentasFila cuentas = this.datos.get(rowIndex);

		switch (columnIndex) {
		case 1:
			cuentas.setNumero((String) value);// Empiezan en case 1 porque el id no le edito
			break;
		case 2:
			cuentas.setIban((String) value);
			break;
		case 3:
			cuentas.setSaldo((int) value);
			break;
		case 4:
			cuentas.setSeleccionable((boolean)value);
			break;
		default:
			break;
		}
		// TO DO actualizar en base de datos
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	public void agregarDatosDeTabla(ArrayList<CuentaDTO> cuentasBD) {
		for (int i = 0; i < cuentasBD.size(); i++) {
			CuentaDTO cuentaDTO = cuentasBD.get(i);
			CuentasFila datosFila = new CuentasFila(cuentaDTO.getId(), cuentaDTO.getNumero(), cuentaDTO.getIban(),
					cuentaDTO.getSaldo(),false);
			this.datos.add(datosFila);
		}
	}
	public ArrayList<CuentasFila> getDatos() {
		return datos;
	}
}
