package modelo;

import java.util.List;

public interface DAOpruebaInterface {

	boolean create(DTOpruebaVO prueba);
	boolean delete(int prueba_id);
	boolean update(DTOpruebaVO prueba);
	DTOpruebaVO getById(int prueba_id);
	List<DTOpruebaVO> getAll();
	
}
