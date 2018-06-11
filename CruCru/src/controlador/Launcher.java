package controlador;

import java.awt.EventQueue;
import vista.InicioWindowBuilderPro;

public class Launcher {
	public static void main(final String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioWindowBuilderPro frame = new InicioWindowBuilderPro();
					frame.mostrarVentana();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}