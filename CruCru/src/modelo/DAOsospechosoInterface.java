package modelo;

import java.util.List;

public interface DAOsospechosoInterface {

	boolean create(DTOsospechosoVO sospechoso);
	boolean delete(int id);
	boolean update(DTOsospechosoVO sospechoso);
	DTOsospechosoVO getById(int id);
	DTOsospechosoVO getByDNI(String dni);
	List<DTOsospechosoVO> getAll();
	
}
