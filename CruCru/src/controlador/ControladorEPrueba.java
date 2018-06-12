package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.DAOpruebaInterface;
import modelo.DAOpruebaMYSQL;
import modelo.DTOpruebaVO;
import modelo.IIteradorVistas;
import modelo.IteradorVistas;

public class ControladorEPrueba {

	private IIteradorVistas<DTOpruebaVO> iterador;
	private DAOpruebaInterface DAO;
	List<DTOpruebaVO> pruebas;
	
	public ControladorEPrueba(){
		DAO = new DAOpruebaMYSQL();
	}
	
	public List<DTOpruebaVO> getAll(){
		pruebas = DAO.getAll();
		iterador = new IteradorVistas<DTOpruebaVO>(pruebas);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}

	public List<DTOpruebaVO> primero(){
		iterador.primero();
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOpruebaVO> siguiente(){
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return iterador.Actual();
	}
	
	public List<DTOpruebaVO> anterior(){
		List<DTOpruebaVO> anterior = iterador.Anterior();
		if(anterior != null){
			return anterior;
		}
		return iterador.Actual();
	}
	
	public void elimina(int index){
		if(index > 0){
		DAO.delete(iterador.Actual().get(index-1).getPrueba_id());
		}
	}
	
	public List<DTOpruebaVO> buscarByID(int ID){
		pruebas = new ArrayList<DTOpruebaVO>();
		iterador = new IteradorVistas<DTOpruebaVO>(pruebas);
		pruebas.add(DAO.getById(ID));
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	public void actualizar(DTOpruebaVO prueba){
		DAO.update(prueba);
	}
}