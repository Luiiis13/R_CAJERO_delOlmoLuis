package vista;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.dto.MovimientoDTO;
import modelo.tabla.MovimientoFila;

public class ModeloTablaMovimientos extends AbstractTableModel implements TableModel {
	private static int Columnas = 3;
	private ArrayList<MovimientoFila> datos;

	public ModeloTablaMovimientos() {
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		MovimientoFila movimiento = this.datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return movimiento.getId();
		case 1:
			return movimiento.getTipo();
		case 2:
			return movimiento.getFechaDelMovimiento();

		default:
			return null;
		}
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Tipo";
		case 2:
			return "Fecha";
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
			return Date.class;
		default:
			return Object.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void agregarDatosDeTabla(ArrayList<MovimientoDTO> movimientosDTO) {
		for (int i = 0; i < movimientosDTO.size(); i++) {
			MovimientoDTO movimientoDTO = movimientosDTO.get(i);
			MovimientoFila datosFila = new MovimientoFila(movimientoDTO.getId(), movimientoDTO.getFechaDelMovimiento(),
					movimientoDTO.getTipo());
			this.datos.add(datosFila);
		}
	}

}
