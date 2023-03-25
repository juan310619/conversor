package Divisas;

import java.util.HashMap;

import Distancia.CambioDistancia;

public  class CambioDinero{
	
	private HashMap<String, Double> tasaDeCambioOriginal;
	
	
	public CambioDinero() {
		
		tasaDeCambioOriginal = new HashMap<>();
		tasaDeCambioOriginal.put("pesos COP a dolar", 0.00021);
		tasaDeCambioOriginal.put("pesos COP a euros", 0.00019);
		tasaDeCambioOriginal.put("Pesos COP a Yen", 0.027);
		tasaDeCambioOriginal.put("Pesos COP a Won", 0.27);
		tasaDeCambioOriginal.put("Pesos COP a GBP", 0.00017);
		tasaDeCambioOriginal.put("dolar a pesos COP", 4722.83);
		tasaDeCambioOriginal.put("euros a pesos COP", 5195.20);
		tasaDeCambioOriginal.put("Yen a pesos COP", 36.48);
		tasaDeCambioOriginal.put("Won a pesos COP", 3.69);
		tasaDeCambioOriginal.put("GBP a pesos COP", 5864.61);
		
	}

	

	

	public HashMap<String, Double> getTasaDeCambio() {
		return tasaDeCambioOriginal;
	}

	
}
