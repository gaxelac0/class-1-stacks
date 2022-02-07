package main.exercises;

import main.utils.Nodo;

public class EjercicioDinamicos {
	
	public static Nodo eliminar(Nodo inicial, int x) {
		if(inicial != null) {
			if(inicial.valor == x) {
				inicial = inicial.sig;
				return inicial;
			}
			else {
				Nodo viajero = inicial;
				while(viajero.sig != null && viajero.sig.valor != x)
					viajero = viajero.sig;
				
				if(viajero.sig != null)
					viajero.sig = viajero.sig.sig;

				return inicial;
			}
		} 
		else {
			return null;	
		}
	}
	
	public static Nodo agregarNodoFinal(Nodo inicial, int x) {
		
		Nodo nodo = new Nodo();
		nodo.valor = x;
		
		if(inicial == null) {
			inicial = nodo;
			return inicial;
		}
		
		Nodo viajero = inicial;
		while(viajero.sig != null) {
			viajero = viajero.sig;
		}
	
		viajero.sig = nodo;
		return inicial;
	}
	
	public static void nodoAlFinal() {
	
		Nodo inicial = null;
		inicial = agregarNodoFinal(inicial, 1);
		inicial = agregarNodoFinal(inicial, 2);
		inicial = agregarNodoFinal(inicial, 3);
		inicial = agregarNodoFinal(inicial, 4);
		inicial = agregarNodoFinal(inicial, 5);
		mostrarLista(inicial);
	}
	
	public static void mostrarLista(Nodo inicial) {
		
		Nodo viajero = inicial;
		while(viajero != null) {
			System.out.println(viajero.valor);
			viajero = viajero.sig;
		}
	}

}
