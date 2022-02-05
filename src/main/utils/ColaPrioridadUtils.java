package main.utils;

import main.impl.cola.ColaPrioridadEstatica;
import main.interfaces.ColaPrioridadTDA;

public class ColaPrioridadUtils {
	
	public static ColaPrioridadTDA copiarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA copia = new ColaPrioridadEstatica();
		ColaPrioridadTDA aux = new ColaPrioridadEstatica();
		
		while(!cola.colaVacia()) {
			aux.acolarPrioridad(cola.primero(), cola.prioridad());
			cola.desencolar();
		}
		
		while(!aux.colaVacia()) {
			cola.acolarPrioridad(aux.primero(), aux.prioridad());
			copia.acolarPrioridad(aux.primero(), aux.prioridad());
			aux.desencolar();
		}
		
		return copia;
	}
	
	public static void mostrarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.println("Valor: " + copia.primero() + ", Prioridad: " + copia.prioridad());
			copia.desencolar();
		}
		
	}

}
