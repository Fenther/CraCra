package vista;

public class DirectorBuilderEntradas {
	private BuilderEntradas builder;
	
	public DirectorBuilderEntradas(BuilderEntradas builder){
		this.builder = builder;
	}
	
	public void ConstruirVistaEntrada(){
		builder.crearFrame();
		builder.crearPanelBuscar();
		builder.crearBotonesIterador();
		builder.crearMarcoTabla();
		builder.crearTabla();
		builder.mostrarVentana();
	}
}
