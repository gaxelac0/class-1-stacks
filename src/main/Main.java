package main;

import main.impl.ColaEstatica;
import main.interfaces.ColaTDA;

public class Main {

	public static void main(String[] args) {
		
		ColaTDA cola = new ColaEstatica();
		cola.acolar(1);
		cola.acolar(1);
		cola.acolar(1);
		cola.acolar(1);
	}
	
	public static void mostrarCola(ColaTDA cola) {
		//while() {
			//
		//}
	}
	
	public static void copiar(ColaTDA cola) {
		ColaTDA copia = new ColaEstatica();
		ColaTDA aux = new ColaEstatica();
		
		while(!cola.colaVacia()) {
			aux.acolar(cola.primero());
			cola.desacolar();
		}
		
		while (!aux.colaVacia()) {
			
		}
	}
}
