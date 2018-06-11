package controlador;

public class FlagsUsuario {
	private boolean admin;
	private boolean agente;
	private boolean agentePruebas;
	
	public FlagsUsuario(boolean admin, boolean agente, boolean agentePruebas) {
		this.admin = admin;
		this.agente = agente;
		this.agentePruebas = agentePruebas;
	}
	
	public boolean getAdmin() {
		return this.admin;
	}
	
	public boolean getAgente() {
		return this.agente;
	}
	
	public boolean getAgentePruebas() {
		return this.agentePruebas;
	}
}