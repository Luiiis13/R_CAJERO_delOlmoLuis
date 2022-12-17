package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.IngresarDineroFrame;


public class IngresarDineroBotonListener implements ActionListener{
		private IngresarDineroFrame frame;

		public IngresarDineroBotonListener(IngresarDineroFrame frame) {
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			float ingresoUsuario = Float.parseFloat(this.frame.getCantidadSpinner().getValue().toString());
			float saldoActual = SesionControlador.datosCuenta.getSaldo();
			// System.out.print(saldoUsuario);
			float saldoTotalIngresado = (saldoActual + ingresoUsuario);
			if (ingresoUsuario >= 0) {
				try {
					SesionControlador.datosCuenta.setSaldo(saldoTotalIngresado);
					CuentaDAO cuentaDAO = new CuentaDAO();
					cuentaDAO.actualizarCuenta(SesionControlador.datosCuenta);
					MovimientoDAO movimientoDAO = new MovimientoDAO();
					long millis=System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
					MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Ingreso de dinero",SesionControlador.datosCuenta.getId());
					movimientoDAO.insertarMovimiento(movimientoDTO);
					JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
					this.frame.show(false);
				} catch (Exception error) {
					SesionControlador.datosCuenta.setSaldo(saldoActual);
					JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
					System.out.print(error);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingreso invalido", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}
}
