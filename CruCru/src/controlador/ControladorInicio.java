package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.MenuWindowBuilderProAgente;
import vista.MenuWindowBuilderProArresto;
import vista.MenuWindowBuilderProPrueba;

public class ControladorInicio {

	public static ActionListener funcionalidadBotonAdministrador(JFrame ventana){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				ControladorM.setPrivilegio(new FlagsUsuario(true, false, false));
				MenuWindowBuilderProAgente window = new MenuWindowBuilderProAgente();
				window.mostrarVentana();
			}
		};
	}
	
	public static ActionListener funcionalidadBotonAgente(JFrame ventana){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				ControladorM.setPrivilegio(new FlagsUsuario(false, true, false));
				MenuWindowBuilderProArresto window = new MenuWindowBuilderProArresto();
				window.mostrarVentana();
			}
		};
	}
	
	public static ActionListener funcionalidadBotonAgentePruebas(JFrame ventana){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				ControladorM.setPrivilegio(new FlagsUsuario(false, false, true));
				MenuWindowBuilderProPrueba window = new MenuWindowBuilderProPrueba();
				window.mostrarVentana();
			}
		};
	}
	
}
