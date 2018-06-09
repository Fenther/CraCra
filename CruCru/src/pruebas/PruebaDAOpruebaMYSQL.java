package pruebas;

import static org.junit.Assert.*;

import java.util.List;

import modelo.DAOpruebaInterface;
import modelo.DAOpruebaMYSQL;
import modelo.DTOpruebaVO;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaDAOpruebaMYSQL {

	@Test
	public void test00Create() {
		DTOpruebaVO prueba = new DTOpruebaVO(1000,"Prueba de prueba","categoriaPrueba");
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		assertTrue(DAOprueba.create(prueba));
	}

	@Test
	public void test01Update() {
		DTOpruebaVO prueba = new DTOpruebaVO(1000,"MODIFICADA","categoriaMODIFICADA");
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		assertTrue(DAOprueba.update(prueba));
	}

	@Test
	public void test02GetById() {
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		DTOpruebaVO prueba = DAOprueba.getById(1000);
		assertTrue(prueba.getPrueba_id() == 1000);
	}

	@Test
	public void test03GetAll() {
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		List<DTOpruebaVO> pruebas = DAOprueba.getAll();
		assertTrue(pruebas.size() == 1);
	}

	@Test
	public void test04Delete() {
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		assertTrue(DAOprueba.delete(1000));
	}
}
