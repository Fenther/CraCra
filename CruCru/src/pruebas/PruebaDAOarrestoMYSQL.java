package pruebas;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import modelo.DAOagenteInterface;
import modelo.DAOagenteMYSQL;
import modelo.DAOarrestoInterface;
import modelo.DAOarrestoMYSQL;
import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOagenteVO;
import modelo.DTOarrestoVO;
import modelo.DTOsospechosoVO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaDAOarrestoMYSQL {

	private static final int AGENTE = 10000;
	private static final int SOSPECHOSO = 100;
	private static DAOarrestoInterface DAOarresto;
	 
	@BeforeClass
	public static void init(){
		DAOarresto = new DAOarrestoMYSQL();
		DTOagenteVO agente = new DTOagenteVO(AGENTE,"Jose","Clarez");
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DTOsospechosoVO sospechoso = new DTOsospechosoVO(SOSPECHOSO,"Nano","NAN", "Masculino", "Caucasico", 21, "75684868W");
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		
		DAOsospechoso.create(sospechoso);
		DAOagente.create(agente);
	}
	
	@AfterClass
	public static void end(){
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		
		DAOsospechoso.delete(SOSPECHOSO);
		DAOagente.delete(AGENTE);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test00Create() {
		DTOarrestoVO arresto = new DTOarrestoVO(10, SOSPECHOSO, AGENTE, new Date(2018,6,9), new Time(2,22,0));
		assertTrue(DAOarresto.create(arresto));	
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test01Update() {
		DTOarrestoVO arresto = new DTOarrestoVO(10, SOSPECHOSO, AGENTE, new Date(2006,6,6), new Time(1,11,0));
		assertTrue(DAOarresto.update(arresto));	
	}

	@Test
	public void test02GetById() {
		DTOarrestoVO arresto = DAOarresto.getById(10);
		assertTrue(arresto.getId() == 10);	
	}

	@Test
	public void test03GetByDetenido() {
		List<DTOarrestoVO> arrestos = DAOarresto.getByDetenido(SOSPECHOSO);
		assertTrue(arrestos.size() == 1);	
	}

	@Test
	public void test04GetByAgente() {
		List<DTOarrestoVO> arrestos = DAOarresto.getByAgente(AGENTE);
		assertTrue(arrestos.size() == 1);
	}

	@Test
	public void test05GetAll() {
		List<DTOarrestoVO> arrestos = DAOarresto.getAll();
		assertTrue(arrestos.size() == 1);
	}

	@Test
	public void test06Delete() {
		assertTrue(DAOarresto.delete(10));
	}
	
}
