package main.utils;

import main.impl.cola.ColaEstatica;
import main.interfaces.ColaTDA;

public class ColaUtils {
	
	public static void mostrarCola(ColaTDA cola) {
		ColaTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.print(copia.primero());
			copia.desacolar();
		}
	}
	
	public static ColaTDA copiarCola(ColaTDA cola) {
		ColaTDA copia = new ColaEstatica();
		ColaTDA aux = new ColaEstatica();
		
		while(!cola.colaVacia()) {
			aux.acolar(cola.primero());
			cola.desacolar();
		}
		
		while(!aux.colaVacia()) {
			cola.acolar(aux.primero());
			copia.acolar(aux.primero());
			aux.desacolar();
		}
		
		return copia;
	}

}
