package Distancia;

import java.util.HashMap;

public class CambioDistancia {
	
	private HashMap<String, Double> tasaDeCambioOriginalD;
	
	
	public CambioDistancia() {
		tasaDeCambioOriginalD = new HashMap<>();
		tasaDeCambioOriginalD.put("metros a centimetros", 100.0);
		tasaDeCambioOriginalD.put("metros a kilometros", 0.001);
		tasaDeCambioOriginalD.put("metros a milimetros", 1000.0);
		tasaDeCambioOriginalD.put("metros a pie", 0.029);
		tasaDeCambioOriginalD.put("centimetros a metros", 0.01);
		tasaDeCambioOriginalD.put("kilometros a metros", 1000.0);
		tasaDeCambioOriginalD.put("milimetros a metros", 0.001);
		tasaDeCambioOriginalD.put("pie a metros", 0.3048);
		
		
		
		
	}

	public HashMap<String, Double> getTasaDeCambioOriginalD() {
		return tasaDeCambioOriginalD;
	}

	

	

	
}

