package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.dao.SesionDAO;
import modelo.dto.SesionDTO;
import vista.Sesion;

public class SesionListener implements ActionListener {
	private SesionDAO sesionDAO;
	private Sesion sesionVista;

	public SesionListener(SesionDAO nuevaSesionDAO, Sesion Sesion) {
		this.sesionDAO = nuevaSesionDAO;
		this.sesionVista = Sesion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.verificarCredenciales();
	}

	private void verificarCredenciales() {
		try {
			int numeroTarjeta = Integer.parseInt(this.sesionVista.getNumeroTarjeta().getText());
			int pin = Integer.parseInt(this.sesionVista.getPin().getText());
			SesionDTO sesionDTO = new SesionDTO(numeroTarjeta, pin);
			boolean valido = this.sesionDAO.verificarSesion(sesionDTO);
			if (valido == true) {
				JOptionPane.showMessageDialog(null, "Credenciales validas");
			} else {
				JOptionPane.showMessageDialog(null, "Credenciales no validas");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Formato no valido");

		}
	}
}
