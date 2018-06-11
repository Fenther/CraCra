package controlador;

import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOsospechosoVO;

public class ControladorMSospechoso extends ControladorM {

	public static void funcionalidadBotonAñadir(int id, String nombre, String apellido, String sexo, String raza, int edad, String dni) {
		DTOsospechosoVO sospechoso = new DTOsospechosoVO(id, nombre, apellido,
				sexo, raza, edad, dni);
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		DAOsospechoso.create(sospechoso);
	}
}
