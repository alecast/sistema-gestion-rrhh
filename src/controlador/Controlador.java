package controlador;
import modelo.*;
import vista.*;

public class Controlador {

	Login vista;
	UsuarioVO modelo;

	public Controlador (Login vista, UsuarioVO modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	
	public void inicializar() {
		vista.pack();
		vista.setVisible(true);
	}
}
