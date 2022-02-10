package main.utils;

import main.impl.cola.ColaPrioridadDinamica;
import main.impl.cola.ColaPrioridadEstatica;
import main.interfaces.ColaPrioridadTDA;

public class ColaPrioridadUtils {
	
	public static ColaPrioridadTDA copiarCola(ColaPrioridadEstatica cola) {
		
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
	
	public static void mostrarCola(ColaPrioridadEstatica cola) {
		
		ColaPrioridadTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.println("Valor: " + copia.primero() + ", Prioridad: " + copia.prioridad());
			copia.desencolar();
		}
		
	}
	
	public static ColaPrioridadDinamica copiarCola(ColaPrioridadDinamica cola) {
		
		ColaPrioridadDinamica copia = new ColaPrioridadDinamica();
		ColaPrioridadDinamica aux = new ColaPrioridadDinamica();
		
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
	
	public static void mostrarCola(ColaPrioridadDinamica cola) {
		
		ColaPrioridadTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.println("Valor: " + copia.primero() + ", Prioridad: " + copia.prioridad());
			copia.desencolar();
		}
		
	}
	
	

}
