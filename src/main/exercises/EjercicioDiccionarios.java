package main.exercises;

import main.impl.diccionario.DiccionarioSimpleEstatico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioMultipleTDA;
import main.interfaces.DiccionarioSimpleTDA;
import main.utils.ConjuntoUtils;

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

}
