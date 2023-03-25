package Divisas;

import Gui.VentanaDinero;
import Gui2.VentanaDistancia;
import Implementacion.Implement;


public class Ventanas {
	 
	Implement operaciones;
	
	public Ventanas(String tipo) throws Exception {
		operaciones = new Implement();
		validacion(tipo);
		
	}

	private void validacion(String tipo) {
		if(tipo.equals("dinero")) {
			presentarVentana();
		}else {
			PresentarVentadaDistancia();
		}
		
	}

	private void presentarVentana() {
		VentanaDinero miVentana = new VentanaDinero();
		miVentana.asignaOperaciones(operaciones);
		miVentana.setVisible(true);
		
		
	}
	
	private void PresentarVentadaDistancia() {
		VentanaDistancia ventadis = new VentanaDistancia();
		ventadis.asignaOperaciones(operaciones);
		ventadis.setVisible(true);
	}
	
}
