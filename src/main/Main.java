package main;

import main.impl.ConjuntoEstatico;
import main.interfaces.ConjuntoTDA;
import main.utils.ConjuntoUtils;

public class Main {

	public static void main(String[] args) {
		
		ConjuntoTDA conjunto = new ConjuntoEstatico();
		conjunto.agregar(1);
		conjunto.agregar(1);
		conjunto.agregar(2);
		conjunto.agregar(3);
		conjunto.agregar(7);
		conjunto.agregar(5);
		
		ConjuntoUtils.mostrarConjunto(conjunto);
		System.out.println();
		System.out.print(conjunto.elegir());
		System.out.print(conjunto.elegir());
		System.out.print(conjunto.elegir());
		System.out.println();
		conjunto.quitar(7);
		conjunto.quitar(3);
		System.out.println();
		ConjuntoUtils.mostrarConjunto(conjunto);
	}
}
