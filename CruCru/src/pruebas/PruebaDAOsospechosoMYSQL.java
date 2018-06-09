package pruebas;

import static org.junit.Assert.*;

import java.util.List;

import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOsospechosoVO;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaDAOsospechosoMYSQL {

	@Test
	public void test00Create() {
		DTOsospechosoVO sospechoso = new DTOsospechosoVO(100,"Nano","NAN", "Masculino", "Caucasico", 21, "75684868W");
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		assertTrue(DAOsospechoso.create(sospechoso));
	}

	@Test
	public void test01Update() {
		DTOsospechosoVO sospechoso = new DTOsospechosoVO(100,"Valencie","Nada", "Masculino", "Caucasico", 21, "75684868W");
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		assertTrue(DAOsospechoso.update(sospechoso));
	}

	@Test
	public void test02GetById() {
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		DTOsospechosoVO sospechoso = DAOsospechoso.getById(100);
		assertTrue(sospechoso.getSospechoso_id() == 100);
	}

	@Test
	public void test03GetByDNI() {
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		DTOsospechosoVO sospechoso = DAOsospechoso.getByDNI("75684868W");
		assertTrue(sospechoso.getSospechoso_id() == 100);
	}

	@Test
	public void test04GetAll() {
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		List<DTOsospechosoVO> sospechosos = DAOsospechoso.getAll();
		assertTrue(sospechosos.size() == 1);
	}

	@Test
	public void test05Delete() {
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		assertTrue(DAOsospechoso.delete(100));
	}
	
}
