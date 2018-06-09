package modelo;

import java.util.List;

public interface DAOinformeInterface {
	
	boolean create(DTOinformeVO informe);
	boolean delete(int id_prueba, int id_arresto);
	boolean update(DTOinformeVO informe);
	DTOinformeVO get(int id_prueba,int id_arresto);
	List<DTOinformeVO> getByPrueba(int id_prueba);
	List<DTOinformeVO> getByArresto(int id_arresto);
	List<DTOinformeVO> getAll();
	
}
