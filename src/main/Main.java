package main;

import main.impl.conjunto.ConjuntoDinamico;
import main.utils.ConjuntoUtils;


public class Main {

	public static void main(String[] args) {

		ConjuntoDinamico c = new ConjuntoDinamico();
		c.agregar(1);
		c.agregar(2);
		c.agregar(3);
		c.quitar(2);
		System.out.println("e:" + c.elegir());
		
		ConjuntoUtils.mostrarConjunto(c);
	}
}
