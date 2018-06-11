package controlador;

import modelo.DAOpruebaInterface;
import modelo.DAOpruebaMYSQL;
import modelo.DTOpruebaVO;

public class ControladorMPrueba extends ControladorM {

	public static void funcionalidadBotonA�adir(int id, String descripcion,
			String categoria) {
		DTOpruebaVO prueba = new DTOpruebaVO(id, descripcion, categoria);
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		DAOprueba.create(prueba);
	}
}
