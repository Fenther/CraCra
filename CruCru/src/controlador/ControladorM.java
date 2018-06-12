package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.DirectorBuilderEntradas;
import vista.EntradasAgenteWindowBuilderPro;
import vista.EntradasArrestoWindowBuilderPro;
import vista.EntradasInformeWindowBuilderPro;
import vista.EntradasPruebaWindowBuilderPro;
import vista.EntradasSospechosoWindowBuilderPro;
import vista.MenuWindowBuilderProAgente;
import vista.MenuWindowBuilderProArresto;
import vista.MenuWindowBuilderProInforme;
import vista.MenuWindowBuilderProPrueba;
import vista.MenuWindowBuilderProSospechoso;

public class ControladorM {

	public static FlagsUsuario privilegio;

	public static FlagsUsuario getPrivilegio() {
		return privilegio;
	}

	public static void setPrivilegio(FlagsUsuario privilegio) {
		ControladorM.privilegio = privilegio;
	}

	public static ActionListener funcionalidadBotonVistaPrueba(JFrame ventana) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgentePruebas()) {
					ventana.dispose();
					MenuWindowBuilderProPrueba ventana = new MenuWindowBuilderProPrueba();
					ventana.mostrarVentana();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonVistaArresto(JFrame ventana) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgente()) {
					ventana.dispose();
					MenuWindowBuilderProArresto ventana = new MenuWindowBuilderProArresto();
					ventana.mostrarVentana();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonVistaInforme(JFrame ventana) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgente()) {
					ventana.dispose();
					MenuWindowBuilderProInforme ventana = new MenuWindowBuilderProInforme();
					ventana.mostrarVentana();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonVistaSospechoso(
			JFrame ventana) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgente()) {
					ventana.dispose();
					MenuWindowBuilderProSospechoso ventana = new MenuWindowBuilderProSospechoso();
					ventana.mostrarVentana();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonVistaAgente(JFrame ventana) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin()) {
					ventana.dispose();
					MenuWindowBuilderProAgente window = new MenuWindowBuilderProAgente();
					window.mostrarVentana();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonEntradaAgente() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin()) {
					DirectorBuilderEntradas director = new DirectorBuilderEntradas(new EntradasAgenteWindowBuilderPro());
					director.ConstruirVistaEntrada();
				}
			}
		};
	}
	
	public static ActionListener funcionalidadBotonEntradaSospechoso(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgente()) {
					DirectorBuilderEntradas director = new DirectorBuilderEntradas(new EntradasSospechosoWindowBuilderPro());
					director.ConstruirVistaEntrada();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonEntradaPrueba() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgentePruebas()) {
					DirectorBuilderEntradas director = new DirectorBuilderEntradas(new EntradasPruebaWindowBuilderPro());
					director.ConstruirVistaEntrada();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonEntradaArresto() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgente()) {
					DirectorBuilderEntradas director = new DirectorBuilderEntradas(new EntradasArrestoWindowBuilderPro());
					director.ConstruirVistaEntrada();
				}
			}
		};
	}

	public static ActionListener funcionalidadBotonEntradaInforme() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio.getAdmin() || privilegio.getAgente()) {
					DirectorBuilderEntradas director = new DirectorBuilderEntradas(new EntradasInformeWindowBuilderPro());
					director.ConstruirVistaEntrada();
				}
			}
		};
	}
}
