package modelo;

import java.sql.Date;

public class DTOinformeVO {
	
	private int pruebas;
	private int arresto;
	private Date fecha;
	
	public DTOinformeVO(int pruebas, int arresto, Date fecha){
		this.pruebas = pruebas;
		this.arresto = arresto;
		this.fecha = fecha;
	}
	
	public int getPruebas() {
		return pruebas;
	}

	public void setPruebas(int pruebas) {
		this.pruebas = pruebas;
	}

	public int getArresto() {
		return arresto;
	}

	public void setArresto(int arresto) {
		this.arresto = arresto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
