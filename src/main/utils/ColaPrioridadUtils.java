package main.utils;

import main.impl.cola.ColaPrioridadDinamica;
import main.impl.cola.ColaPrioridadEstatica;
import main.interfaces.ColaPrioridadTDA;

public class ColaPrioridadUtils {
	
	
	/**
	 * copiar cola para implementacion estatica
	 * @param cola
	 */
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
	
	/**
	 * mostrar cola para implementacion estatica
	 * @param cola
	 */
	public static void mostrarCola(ColaPrioridadEstatica cola) {
		
		ColaPrioridadTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.println("Valor: " + copia.primero() + ", Prioridad: " + copia.prioridad());
			copia.desencolar();
		}
		
	}
	
	/**
	 * copiar cola para implementacion dinamica
	 * @param cola
	 */
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
	
	/**
	 * mostrar cola para implementacion dinamica
	 * @param cola
	 */
	public static void mostrarCola(ColaPrioridadDinamica cola) {
		
		ColaPrioridadTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.println("Valor: " + copia.primero() + ", Prioridad: " + copia.prioridad());
			copia.desencolar();
		}
		
	}
	
	/**
	 * Determina si las dos colas con prioridad son identicas. 
	 * @param c1
	 * @param c2
	 */
	public static boolean sonIguales(ColaPrioridadDinamica c1, ColaPrioridadDinamica c2) {
		
		ColaPrioridadTDA cola = ColaPrioridadUtils.copiarCola(c1);
		ColaPrioridadTDA cola2 = ColaPrioridadUtils.copiarCola(c2);
		
		// start thinking its a match
		boolean bIguales = true;
		while(bIguales && !cola.colaVacia()) {
			bIguales = (cola.primero()==cola2.primero() && cola.prioridad()==cola2.prioridad());
			cola.desencolar();
			cola2.desencolar();
		}
		
		return (bIguales&&cola2.colaVacia());
	}
	
	

}
