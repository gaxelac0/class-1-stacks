package main.utils;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.conjunto.ConjuntoEstatico;
import main.interfaces.ConjuntoTDA;

public class ConjuntoUtils {
	
	public static void mostrarConjunto(ConjuntoDinamico conjunto) {
		
		ConjuntoTDA copia = copiarConjunto(conjunto);
		while(!copia.conjuntoVacio()) {
			int e = copia.elegir();
			copia.quitar(e);
			System.out.println(e);
		}
	}
	
	public static void mostrarConjunto(ConjuntoEstatico conjunto) {
		
		ConjuntoTDA copia = copiarConjunto(conjunto);
		while(!copia.conjuntoVacio()) {
			int e = copia.elegir();
			copia.quitar(e);
			System.out.println(e);
		}
	}
	
	public static ConjuntoTDA copiarConjunto(ConjuntoEstatico conjunto) {
		
		ConjuntoTDA copia = new ConjuntoEstatico();
		ConjuntoTDA aux = new ConjuntoEstatico();
		while(!conjunto.conjuntoVacio()) {
			
			int e = conjunto.elegir();
			conjunto.quitar(e);
			
			aux.agregar(e);
		}
		
		while(!aux.conjuntoVacio()) {
			int e = aux.elegir();
			aux.quitar(e);
			
			conjunto.agregar(e);
			copia.agregar(e);
		}
		
		return copia;
	}
	
	public static ConjuntoTDA copiarConjunto(ConjuntoDinamico conjunto) {
		
		ConjuntoTDA copia = new ConjuntoDinamico();
		ConjuntoTDA aux = new ConjuntoDinamico();
		while(!conjunto.conjuntoVacio()) {
			
			int e = conjunto.elegir();
			conjunto.quitar(e);
			
			aux.agregar(e);
		}
		
		while(!aux.conjuntoVacio()) {
			int e = aux.elegir();
			aux.quitar(e);
			
			conjunto.agregar(e);
			copia.agregar(e);
		}
		
		return copia;
	}

}
