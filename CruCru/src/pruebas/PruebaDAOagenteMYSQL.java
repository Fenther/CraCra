package pruebas;

import static org.junit.Assert.*;
import modelo.DAOagenteInterface;
import modelo.DAOagenteMYSQL;
import modelo.DTOagenteVO;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaDAOagenteMYSQL {


	@Test
	public void test00Create() {
		DTOagenteVO agente = new DTOagenteVO(10000,"Jose","Clarez");
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		assertTrue(DAOagente.create(agente));
	}

	@Test
	public void test01GetByNumPlaca() {
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DTOagenteVO agente = DAOagente.getByNumPlaca(10000);
		assertTrue(agente.getNum_placa()== 10000);
	}

	@Test
	public void test02GetAll() {
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		assertTrue(DAOagente.getAll().size() == 2);
	}

	@Test
	public void test03Update() {
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		DTOagenteVO agente = DAOagente.getByNumPlaca(10000);
		agente.setNombre("Juan");
		assertTrue(DAOagente.update(agente));
	}

	@Test
	public void test04Delete() {
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		assertTrue(DAOagente.delete(10000));
	}

}
