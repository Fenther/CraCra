package modelo;

import java.util.List;

public interface DAOarrestoInterface {

	boolean create(DTOarrestoVO arresto);
	boolean delete(int id);
	boolean update(DTOarrestoVO arresto);
	DTOarrestoVO getById(int id);
	List<DTOarrestoVO> getByDetenido(int detenido_id);
	List<DTOarrestoVO> getByAgente(int num_placa);
	List<DTOarrestoVO> getAll();
	
}
