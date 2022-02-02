package main.utils;

import main.impl.PilaEstaticaTopeInicial;
import main.interfaces.PilaTDA;

public class PilaUtils {
	
	public static void pilaTest() {
		PilaTDA pila = new PilaEstaticaTopeInicial();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		mostrarPila(pila);
		
	}
	
	public static void mostrarPila(PilaTDA pila) {
		
		PilaTDA aux = copiarPila(pila);
		while(!aux.pilaVacia()) {
			System.out.println(aux.tope());
			aux.desapilar();
		}
		
	}
	
	public static PilaTDA copiarPila(PilaTDA pila) {
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
