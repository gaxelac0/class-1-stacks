package main;

import main.impl.PilaEstaticaTopeInicial;
import main.interfaces.PilaTDA;

public class Main {

	public static void main(String[] args) {

		PilaTDA pila = new PilaEstaticaTopeInicial();
		pila.apilar(1);
		pila.apilar(23);
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
		PilaTDA copia = new PilaEstaticaTopeInicial();
		PilaTDA aux = new PilaEstaticaTopeInicial();
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
