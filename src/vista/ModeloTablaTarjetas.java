package vista;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.dto.TarjetaDTO;
import modelo.tabla.TarjetaFila;

/***
 * Clase que implementa la vista de los datos de tarjetas en forma de tablas
 * 
 * @author Luis
 *
 */
public class ModeloTablaTarjetas extends AbstractTableModel implements TableModel {
	public static int columnas = 5;
	private ArrayList<TarjetaFila> datos;

	public ModeloTablaTarjetas() {
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
			return "Fecha de expiracion";
		case 3:
			return "CVV";
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
			return Date.class;
		case 3:
			return Integer.class;
		case 4:
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
		TarjetaFila tarjeta = this.datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tarjeta.getId();
		case 1:
			return tarjeta.getNumero();
		case 2:
			return tarjeta.getFecha_expiracion();
		case 3:
			return tarjeta.getCvv();
		case 4:
			return tarjeta.isSeleccionable();

		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		TarjetaFila tarjeta = this.datos.get(rowIndex);

		switch (columnIndex) {
		case 1:
			tarjeta.setNumero((String) value);// Empiezan en case 1 porque el id no le edito
			break;
		case 2:
			tarjeta.setFecha_expiracion((Date) value);
			break;
		case 3:
			tarjeta.setCvv((int) value);
			break;
		case 4:
			tarjeta.setSeleccionable((boolean) value);
		default:
			break;
		}
		// TO DO actualizar en base de datos
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	/***
	 * Metodo que añade los distintos datos de tarjeta al arrayList de "datos"
	 * 
	 * @param tarjetasBD parametro que sirve para buscar una tarjeta y poder
	 *                   conseguir sus datos
	 */
	public void agregarDatosDeTabla(ArrayList<TarjetaDTO> tarjetasBD) {
		for (int i = 0; i < tarjetasBD.size(); i++) {
			TarjetaDTO tarjetaDTO = tarjetasBD.get(i);
			TarjetaFila datosFila = new TarjetaFila(tarjetaDTO.getId(), tarjetaDTO.getNumero(),
					tarjetaDTO.getFecha_expiracion(), tarjetaDTO.getCvv(), tarjetaDTO.getPin(), false,
					tarjetaDTO.isBloqueado(), tarjetaDTO.getIdCuentaAsociada());
			this.datos.add(datosFila);
		}
	}

	public ArrayList<TarjetaFila> getDatos() {
		return datos;
	}

}
