package controlador;
import modelo.*;
import vista.*;

public class Main {

	public static void main(String[] args) {
		// Hardcodeo un usuario hasta que tengamos la base de datos
		UsuarioVO[] usuarios = new UsuarioVO[2];
		usuarios[0] = new UsuarioVO();
		usuarios[0].setNombre_usuario("admin");
		usuarios[0].setContraseña("1234");
		
		Login vista = new Login();
		Controlador controlador = new Controlador(vista, usuarios[0]);
		controlador.inicializar();
		
	}

}
