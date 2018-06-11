package modelo;

import java.util.ArrayList;
import java.util.List;

final public class IteradorVistas<T> implements IIteradorVistas<T> {

	private List<T> vistas;
	private int posicionActual;
	public static final int TAMAÑOVISTAS = 10;

	public IteradorVistas(List<T> listado) {
		this.vistas = listado;
		this.posicionActual = -1;
	}

	@Override
	public void primero() {
		this.posicionActual = -1;
	}

	@Override
	public List<T> Actual() {
		if ((this.vistas == null) || (this.vistas.size() == 0)
				|| (posicionActual > this.vistas.size() - 1)
				|| (this.posicionActual < 0)) {
			return null;
		} else {
			List<T> actual = new ArrayList<T>();
			int marcador = this.posicionActual;
			for (int i = 0; (i < TAMAÑOVISTAS)
					&& (this.vistas.size() > marcador); i++) {
				actual.add(this.vistas.get(marcador));
				marcador++;
			}
			return actual;
		}
	}

	@Override
	public List<T> Siguiente() {
		if ((this.vistas == null) || (this.vistas.size() == 0)
				|| (posicionActual+1 > this.vistas.size() - 1)) {
			return null;
		} else {
			if (this.posicionActual == -1) {
				this.posicionActual = 0;
			} else {
				this.posicionActual += TAMAÑOVISTAS;
			}
			List<T> siguiente = new ArrayList<T>();
			int marcador = this.posicionActual;
			for (int i = 0; (i < 10) && (this.vistas.size() > marcador); i++) {
				siguiente.add(this.vistas.get(marcador));
				marcador++;
			}
			return siguiente;
		}
	}

	public List<T> Anterior() {
		if ((this.vistas == null) || (this.vistas.size() == 0)
				|| (posicionActual - TAMAÑOVISTAS < 0)) {
			return null;
		} else {
			this.posicionActual -= TAMAÑOVISTAS;
			List<T> anterior = new ArrayList<T>();
			int marcador = this.posicionActual;
			for (int i = 0; (i < TAMAÑOVISTAS) && (this.vistas.size() > marcador); i++) {
				anterior.add(this.vistas.get(marcador));
				marcador++;
			}
			return anterior;
		}
	}

	@Override
	public boolean quedanElementos() {
		return ((this.vistas != null) && (posicionActual + 1 <= this.vistas
				.size() - 1));
	}

}
