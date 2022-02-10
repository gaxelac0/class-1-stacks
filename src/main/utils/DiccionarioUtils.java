package main.utils;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioMultipleTDA;
import main.interfaces.DiccionarioSimpleTDA;

public class DiccionarioUtils {
	
	public static void mostrarDiccionario(DiccionarioSimpleTDA dict) {
		
		ConjuntoTDA claves = dict.claves();
		while(!claves.conjuntoVacio()) {
			
			int n = claves.elegir();
			System.out.println("Clave: " + n + ", Valor: " + dict.recuperar(n));
			claves.quitar(n);
		}
	}
	
	public static void mostrarDiccionario(DiccionarioMultipleTDA dict) {
		
		ConjuntoTDA claves = dict.claves();
		while(!claves.conjuntoVacio()) {
			
			int n = claves.elegir();
			System.out.print("Clave: " + n + ", " + "Valores: {");
			ConjuntoUtils.mostrarConjunto((ConjuntoDinamico)dict.recuperar(n));
			System.out.println( "}");
			claves.quitar(n);
		}
	}

}
