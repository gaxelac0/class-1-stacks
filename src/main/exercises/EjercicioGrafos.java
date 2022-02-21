package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.pila.PilaDinamica;
import main.interfaces.ConjuntoTDA;
import main.interfaces.GrafoTDA;
import main.interfaces.PilaTDA;

public class EjercicioGrafos {
	
	/** Ejercicio TP6.4)
	Dado un Grafo G y un v�rtice v, calcular el conjunto de v�rtices AdyacentesDobles de v.
	Se define que un v�rtice w es adyacente doble de un v�rtice v, si existe otro v�rtice x y hay
	una arista que comienza en v y termina en x y otra que comienza en x y termina en w.
	*/
	public static ConjuntoTDA adyacenteDoble(GrafoTDA g, int v) {
		
		// TODO
		
		return null;
	}
	
	/**
	Dado un Grafo G y un v�rtice v, escribir un m�todo que permita obtener el conjunto de los
	Predecesores del v�rtice v en G.
	Se define que un v�rtice o es predecesor de otro v�rtice d, si hay una arista que comienza
	en o y termina en d
	*/
	public static ConjuntoTDA predecesores(GrafoTDA g, int v) {
		
		ConjuntoTDA predecesores = new ConjuntoDinamico();
		
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int elegido = vertices.elegir();
			vertices.quitar(elegido);
			
			if(g.existeArista(elegido, v)) {
				predecesores.agregar(elegido);
			}
		}
		return predecesores;
	}

}
