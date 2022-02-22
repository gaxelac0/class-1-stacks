package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.GrafoTDA;

public class EjercicioGrafos {

	/** Ejercicio TP6.4)
	Dado un Grafo G y un vértice v, calcular el conjunto de vértices AdyacentesDobles de v.
	Se define que un vértice w es adyacente doble de un vértice v, si existe otro vértice x y hay
	una arista que comienza en v y termina en x y otra que comienza en x y termina en w.
	 */
	public static ConjuntoTDA adyacenteDoble(GrafoTDA g, int v) {
		
		ConjuntoTDA dobles = new ConjuntoDinamico();
		
		ConjuntoTDA adyacentes = adyacentes(g, v);
		while(!adyacentes.conjuntoVacio()) {
			
			int e = adyacentes.elegir();
			adyacentes.quitar(e);
			
			ConjuntoTDA aux = adyacentes(g, e);
			while(!aux.conjuntoVacio()) {
				
				int x = aux.elegir();
				aux.quitar(x);
				dobles.agregar(x);	
			}
		}
		
		return dobles;
	}
	
	/**
	 * Metodo que recupera los adyacentes del vertice v
	 * @param g grafo
	 * @param v valor de vertice v
	 * @return conjunto de adyacentes
	 */
	public static ConjuntoTDA adyacentes(GrafoTDA g, int v) {
		
		ConjuntoTDA adyacentes = new ConjuntoDinamico();
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int e = vertices.elegir();
			vertices.quitar(e);
			
			if(g.existeArista(e, v)) {
				adyacentes.agregar(e);
			}
		}
		
		return adyacentes;
	}

	/**
	Dado un Grafo G y un vértice v, escribir un método que permita obtener el conjunto de los
	Predecesores del vértice v en G.
	Se define que un vértice o es predecesor de otro vértice d, si hay una arista que comienza
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
