package controlador;

import java.sql.Date;

import modelo.DAOinformeInterface;
import modelo.DAOinformeMYSQL;
import modelo.DTOarrestoVO;
import modelo.DTOinformeVO;
import modelo.DTOpruebaVO;

public class ControladorMInforme extends ControladorM{

	public static void funcionalidadBotonAñadir(DTOpruebaVO prueba, DTOarrestoVO arresto, Date fecha){
		DTOinformeVO informe = new DTOinformeVO(prueba.getPrueba_id(), arresto.getId(), fecha);
		DAOinformeInterface DAOinforme = new DAOinformeMYSQL();
		DAOinforme.create(informe);
	}
	
}
