package controlador;

import modelo.DAOagenteInterface;
import modelo.DAOagenteMYSQL;
import modelo.DTOagenteVO;

public class ControladorMAgente extends ControladorM {

	public static void funcionalidadBotonAñadir(int numPlaca,
			String nombre, String apellidos) {

		DTOagenteVO agente = new DTOagenteVO(numPlaca, nombre, apellidos);
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DAOagente.create(agente);
	}

}
