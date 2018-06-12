package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.DAOinformeInterface;
import modelo.DAOinformeMYSQL;
import modelo.DTOinformeVO;
import modelo.IIteradorVistas;
import modelo.IteradorVistas;

public class ControladorEInforme {

	private IIteradorVistas<DTOinformeVO> iterador;
	private DAOinformeInterface DAO;
	List<DTOinformeVO> informes;
	
	public ControladorEInforme(){
		DAO = new DAOinformeMYSQL();
	}
	
	public List<DTOinformeVO> getAll(){
		informes = DAO.getAll();
		iterador = new IteradorVistas<DTOinformeVO>(informes);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}

	public List<DTOinformeVO> primero(){
		iterador.primero();
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOinformeVO> siguiente(){
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return iterador.Actual();
	}
	
	public List<DTOinformeVO> anterior(){
		List<DTOinformeVO> anterior = iterador.Anterior();
		if(anterior != null){
			return anterior;
		}
		return iterador.Actual();
	}
	
	public void elimina(int index){
		if(index > 0){
		DAO.delete(iterador.Actual().get(index-1).getPruebas(),iterador.Actual().get(index-1).getArresto());
		}
	}
	
	public List<DTOinformeVO> buscar(int prueba, int arresto){
		informes = new ArrayList<DTOinformeVO>();
		informes.add(DAO.get(prueba, arresto));
		iterador = new IteradorVistas<DTOinformeVO>(informes);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOinformeVO> buscarByPrueba(int prueba){
		informes = DAO.getByPrueba(prueba);
		iterador = new IteradorVistas<DTOinformeVO>(informes);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOinformeVO> buscarByArresto(int arresto){
		informes = DAO.getByArresto(arresto);
		iterador = new IteradorVistas<DTOinformeVO>(informes);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
}
