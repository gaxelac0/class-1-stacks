package main;

import main.impl.cola.ColaDinamica;
import main.interfaces.ColaTDA;
import main.utils.ColaUtils;


public class Main {

	public static void main(String[] args) {
		
		ColaTDA cola = new ColaDinamica();
		cola.acolar(1);
		cola.acolar(3);
		cola.acolar(3);
		cola.acolar(4);
		ColaUtils.mostrarCola(cola);
	}
}
