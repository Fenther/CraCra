package modelo;

import java.sql.Date;
import java.sql.Time;

public class DTOarrestoVO {

	private int id;
	private int detenido;
	private int agente;
	private Date fecha;
	private Time hora;
	
	public DTOarrestoVO(int id, int detenido, int agente, Date fecha, Time hora){
		this.id = id;
		this.detenido = detenido;
		this.agente = agente;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDetenido() {
		return detenido;
	}

	public void setDetenido(int detenido) {
		this.detenido = detenido;
	}

	public int getAgente() {
		return agente;
	}

	public void setAgente(int agente) {
		this.agente = agente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public String toString() {
		return id+"";
	}
	
}
