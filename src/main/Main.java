package main;

import main.impl.ColaEstatica;
import main.interfaces.ColaTDA;
import main.utils.ColaUtils;

public class Main {

	public static void main(String[] args) {
		
		ColaTDA cola = new ColaEstatica();
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		cola.acolar(4);
		cola.desacolar();
		
		ColaUtils.mostrarCola(cola);
	}
}
