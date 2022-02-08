package main;

import main.impl.pila.PilaDinamica;
import main.interfaces.PilaTDA;
import main.utils.PilaUtils;

public class Main {

	public static void main(String[] args) {
		
		PilaTDA pila = new PilaDinamica();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		PilaUtils.mostrarPila(pila);
	}
}
