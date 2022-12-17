package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.ExtraerDineroFrame;

public class ExtraerDineroBotonListener implements ActionListener {
	private ExtraerDineroFrame frame;

	public ExtraerDineroBotonListener(ExtraerDineroFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		float saldoActual = SesionControlador.datosCuenta.getSaldo();
		try {
			float saldoUsuario = Float.parseFloat(this.frame.getCantidadSpinner().getValue().toString());
			// System.out.print(saldoUsuario);
			float saldoRestante = (saldoActual - saldoUsuario);
			if (saldoRestante >= 0) {
				SesionControlador.datosCuenta.setSaldo(saldoRestante);
				CuentaDAO cuentaDAO = new CuentaDAO();
				cuentaDAO.actualizarCuenta(SesionControlador.datosCuenta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis=System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Extracción de dinero");

				JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
				this.frame.show(false);
			} else {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception error) {
			SesionControlador.datosCuenta.setSaldo(saldoActual);
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.print(error);
		}
	}

}
