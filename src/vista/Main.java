package vista;

import java.sql.Date;
import java.util.ArrayList;

import modelo.dao.CajeroDAO;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.RolDAO;
import modelo.dao.TarjetaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.UsuarioRolDAO;
import modelo.dto.CajeroDTO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
import modelo.dto.RolDTO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import modelo.dto.UsuarioRolDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
/*
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		//UsuarioDTO usuario =new UsuarioDTO( 2,"Alfonso", 19,"Nuevo usuario");
		usuarioDAO.eliminarUsuario(2);
	*/	
	/*
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	UsuarioDTO usuario =new UsuarioDTO( 1,"Jose", 19,"Nuevo usuario");
	usuarioDAO.actualizarUsuario(usuario);
	*/
	
		/*
	CajeroDAO actualizarCAjero = new CajeroDAO();
	CajeroDTO cajeroDTo =new CajeroDTO(1,"barcelona");
	actualizarCAjero.actualizarCajero(cajeroDTo);
	CajeroDAO cajeroDAO = new CajeroDAO();
	//CajeroDTO cajeroDTo =new CajeroDTO(1,"barcelona");
	ArrayList<CajeroDTO>cajeros= cajeroDAO.obtenerCajeros();
	for(int i=0;i<cajeros.size();i++) {
		CajeroDTO almacenar = cajeros.get(i);
		System.out.print(almacenar.getUbicacion());
	}
	*/
		/*
		Date fecha=	new Date(1000);
		TarjetaDAO tarjetaDAO = new TarjetaDAO();
		TarjetaDTO tarjeta =new TarjetaDTO(1,875,fecha,002,0001);
		tarjetaDAO.actualizarTarjeta(tarjeta);
	ArrayList<TarjetaDTO>tarjetas=tarjetaDAO.obtenerTarjetas();
	
	for(int i=0;i<tarjetas.size();i++) {
		TarjetaDTO almacenar =tarjetas.get(i);
		System.out.print(almacenar.getNumero());	
		}
	*/
		/*
		CuentaDAO cuentaDAO = new CuentaDAO();
		CuentaDTO cuenta = new CuentaDTO(3, 0001, "1100A", 100.50f , 1, 1);
		cuentaDAO.actualizarCuenta(cuenta);
		ArrayList<CuentaDTO>cuentas=cuentaDAO.obtenerCuentas();
		for(int i=0;i<cuentas.size();i++) {
			CuentaDTO almacenar = cuentas.get(i);
			System.out.print(almacenar.getIban());
		*/
		Date fecha = new Date(1000);
		MovimientoDAO moviminetoDAO = new MovimientoDAO();
		MovimientoDTO movimiento = new MovimientoDTO(3, 3, 3, 400, fecha);
		moviminetoDAO.eliminarMovimiento(4);
		//moviminetoDAO.insertarMovimiento(movimiento);
		moviminetoDAO.actualizarMovimiento(movimiento);
		ArrayList<MovimientoDTO>movimientos=moviminetoDAO.obtenerMovimientos();
		for(int i=0;i<movimientos.size();i++) {
			MovimientoDTO almacenar = movimientos.get(i);
			System.out.print(almacenar.getCantidad());

		}
	}

}


