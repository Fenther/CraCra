package controlador;

import java.sql.Date;
import java.sql.Time;

import modelo.DAOarrestoInterface;
import modelo.DAOarrestoMYSQL;
import modelo.DTOagenteVO;
import modelo.DTOarrestoVO;
import modelo.DTOsospechosoVO;

public class ControladorMArresto extends ControladorM {
	
	public static void funcionalidadBotonAñadir(Date fecha, Time hora, int id, DTOsospechosoVO sospechoso, DTOagenteVO agente ) {
		DAOarrestoInterface DAOarresto = new DAOarrestoMYSQL();
		DTOarrestoVO arresto = new DTOarrestoVO(id, sospechoso.getSospechoso_id(), agente.getNum_placa(), fecha, hora);
		DAOarresto.create(arresto);
	}
}
