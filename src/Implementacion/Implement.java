package Implementacion;

import java.util.HashMap;

import Distancia.CambioDistancia;
import Divisas.CambioDinero;

public class Implement {
	
	HashMap<String, Double> distancia = new CambioDistancia().getTasaDeCambioOriginalD();
	HashMap<String, Double> dinero = new CambioDinero().getTasaDeCambio(); 
	
	

	public double convertir(String entrada,  double cantidad, String tipo) throws Exception {
			
		String llave = entrada; // nos dira que tipo de conversion es
		
		if (tipo == "dinero") {
			if (dinero.containsKey(llave)){
				double valor = dinero.get(llave);
				return  cantidad*valor;
			}
			else {
				throw new Exception("No podemos hacer ese cambio, intente de nuevo");}
			}
			
		else if(tipo=="distancia"){
			if(distancia.containsKey(llave)) {
				double valor = distancia.get(llave);
				return cantidad*valor;
			}
			
			else {
				throw new Exception("No podemos hacer ese cambio, intente de nuevo");}
				
			}
		else {
			throw new Exception("No podemos hacer ese cambio, intente de nuevo");}
			
		
		
	}
	
	public static String Primer(String entrada) {
		String llave = entrada;
		String[] frase = llave.split(" ");
		String primer = frase[0];
		return primer;  // no devuelve la unidad del valor que esta convirtiendo
	}
	
	
	public static String Ultimo(String entrada) {
		String llave = entrada;
		String[] frase = llave.split(" ");
		String ultimo = frase[frase.length-1];
		return ultimo; // nos devuleve la unidad del valor convertido
	}
	
	}
	
	
	
