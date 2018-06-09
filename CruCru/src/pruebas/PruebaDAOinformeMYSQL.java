package pruebas;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import modelo.DAOagenteInterface;
import modelo.DAOagenteMYSQL;
import modelo.DAOarrestoInterface;
import modelo.DAOarrestoMYSQL;
import modelo.DAOinformeInterface;
import modelo.DAOinformeMYSQL;
import modelo.DAOpruebaInterface;
import modelo.DAOpruebaMYSQL;
import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOagenteVO;
import modelo.DTOarrestoVO;
import modelo.DTOinformeVO;
import modelo.DTOpruebaVO;
import modelo.DTOsospechosoVO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaDAOinformeMYSQL {

	private static final int AGENTE = 10000;
	private static final int PRUEBA = 1000;
	private static final int SOSPECHOSO = 100;
	private static final int ARRESTO = 10;
	private static DAOinformeInterface DAOinforme;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void init(){
		DAOinforme = new DAOinformeMYSQL();
		DTOagenteVO agente = new DTOagenteVO(AGENTE,"Jose","Clarez");
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DTOsospechosoVO sospechoso = new DTOsospechosoVO(SOSPECHOSO,"Nano","NAN", "Masculino", "Caucasico", 21, "75684868W");
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		DTOarrestoVO arresto = new DTOarrestoVO(ARRESTO, SOSPECHOSO, AGENTE, new Date(2018,6,9), new Time(2,22,0));
		DAOarrestoInterface DAOarresto = new DAOarrestoMYSQL();
		DTOpruebaVO prueba = new DTOpruebaVO(PRUEBA,"Prueba de prueba","categoriaPrueba");
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		
		DAOsospechoso.create(sospechoso);
		DAOagente.create(agente);
		DAOarresto.create(arresto);
		DAOprueba.create(prueba);
	}
	
	@AfterClass
	public static void end(){
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		DAOarrestoInterface DAOarresto = new DAOarrestoMYSQL();
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		
		DAOsospechoso.delete(SOSPECHOSO);
		DAOagente.delete(AGENTE);
		DAOarresto.delete(ARRESTO);
		DAOprueba.delete(PRUEBA);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test00Create() {
		DTOinformeVO informe = new DTOinformeVO(PRUEBA, ARRESTO, new Date(2018,6,9));
		assertTrue(DAOinforme.create(informe));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test01Update() {
		DTOinformeVO informe = new DTOinformeVO(PRUEBA, ARRESTO, new Date(2006,6,6));
		assertTrue(DAOinforme.update(informe));
	}
	
	@Test
	public void test02Get() {
		DTOinformeVO informe = DAOinforme.get(PRUEBA,ARRESTO);
		assertTrue(informe.getPruebas()== PRUEBA && informe.getArresto() == ARRESTO);
	}

	@Test
	public void test03GetByPrueba() {
		assertTrue(DAOinforme.getByPrueba(PRUEBA).size() == 1);
	}

	@Test
	public void test04GetByArresto(){
		assertTrue(DAOinforme.getByArresto(ARRESTO).size() == 1);		
	}
	
	@Test
	public void test05GetAll(){
		assertTrue(DAOinforme.getAll().size() == 1);
	}
	
	@Test
	public void test06Delete() {
		assertTrue(DAOinforme.delete(PRUEBA, ARRESTO));
	}

}
