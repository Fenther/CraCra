package modelo;

import java.util.ArrayList;

final public class IteradorVistas implements IIteradorVistas {

	private ArrayList<Object[][]> vistas;
	private int posicionActual;
	
	public IteradorVistas(ArrayList<Object[][]> listado){
		this.vistas = listado;
	}
	
	@Override
	public void primero() {
		this.posicionActual = -1;
	}

	@Override
	public Object[][] Actual() {
		if ((this.vistas == null) ||
				(this.vistas.size() == 0) || 
				(posicionActual > this.vistas.size() -1) ||
				(this.posicionActual < 0)){
			return null;
		} else {
			
			return this.vistas.get(posicionActual);
		}
	}

	@Override
	public Object[][] Siguiente() {
		if ((this.vistas == null) ||
				(this.vistas.size() == 0) ||
				(posicionActual + 1 > this.vistas.size() - 1 )){
			return null;
		} else {
			return this.vistas.get(++posicionActual);
		}
	}

	@Override
	public boolean quedanElementos() {
		return (posicionActual+1 <= this.vistas.size() -1);
	}

}
