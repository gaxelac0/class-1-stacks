package main;

import main.impl.PilaEstaticaTopeFinal;
import main.interfaces.PilaTDA;

public class Main {

	public static void main(String[] args) {

		PilaTDA pila = new PilaEstaticaTopeFinal();
		pila.apilar(1);
		pila.apilar(23);
		PilaTDA copia = copiarPila(pila);
		mostrarPila(copia);
		mostrarPila(pila);
	}
	
	private static void mostrarPila(PilaTDA pila) {
		
		PilaTDA aux = copiarPila(pila);
		while(!aux.pilaVacia()) {
			System.out.println(aux.tope());
			aux.desapilar();
		}
		
	}
	
	private static PilaTDA copiarPila(PilaTDA pila) {
		PilaTDA copia = new PilaEstaticaTopeFinal();
		PilaTDA aux = new PilaEstaticaTopeFinal();
		while(!pila.pilaVacia()) {
			aux.apilar(pila.tope());
			pila.desapilar();
		}
		
		while(!aux.pilaVacia()) {
			pila.apilar(aux.tope());
			copia.apilar(aux.tope());
			aux.desapilar();
		}
		return copia;
	}

}
