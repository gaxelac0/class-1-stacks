package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.diccionario.DiccionarioMultipleDinamico;
import main.impl.diccionario.DiccionarioSimpleDinamico;
import main.impl.diccionario.DiccionarioSimpleEstatico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioMultipleTDA;
import main.interfaces.DiccionarioSimpleTDA;
import main.utils.ConjuntoUtils;
import main.utils.DiccionarioUtils;

public class EjercicioDiccionarios {
	
	/*
	 * Multiple a simple
	 */
	public static DiccionarioSimpleTDA m2s(DiccionarioMultipleTDA m) {
		
		DiccionarioSimpleTDA s = new DiccionarioSimpleEstatico();
		ConjuntoTDA claves = m.claves();
		while(!claves.conjuntoVacio()) {
			
			int clave = claves.elegir();
			claves.quitar(clave);
			
			ConjuntoTDA valores = m.recuperar(clave);
			s.agregar(clave, ConjuntoUtils.sumarConjunto(valores));
		}
		
		return s;
	}
	
	// Diagrama 4
	public static void mainImplDictSimpleDinamico() {
		
		DiccionarioSimpleTDA d = new DiccionarioSimpleDinamico();
		d.agregar(101, 0);
		d.agregar(44, 30);
		d.agregar(-22, 66);
		d.agregar(8, 34);
		
		d.eliminar(-22);
		
		DiccionarioUtils.mostrarDiccionario(d);
		
		ConjuntoUtils.mostrarConjunto((ConjuntoDinamico)d.claves());
	}
	
	// Diagrama 5
	public static void mainImplDictMultipleDinamico() {
		
		DiccionarioMultipleDinamico m = new DiccionarioMultipleDinamico();
		m.agregar(4, 1);
		m.agregar(4, 1);
		m.agregar(4, 2);
		m.agregar(7, 3);
		m.eliminarValor(4, 1);

		DiccionarioUtils.mostrarDiccionario(m);
	}

}
