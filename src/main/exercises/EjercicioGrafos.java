package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.GrafoTDA;

public class EjercicioGrafos {

	/** Ejercicio TP6.4)
	Dado un Grafo G y un v�rtice v, calcular el conjunto de v�rtices AdyacentesDobles de v.
	Se define que un v�rtice w es adyacente doble de un v�rtice v, si existe otro v�rtice x y hay
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
			
			if(g.existeArista(v, e)) {
				adyacentes.agregar(e);
			}
		}
		
		return adyacentes;
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
	
	
	/**
	 * Dado un Grafo G escribir un m�todo que permita obtener el conjunto de los v�rtices aislados
		en G.
		Se define que un v�rtice v es aislado si v no tiene aristas entrantes ni salientes.
	 */
	public static ConjuntoTDA aislados(GrafoTDA g) {
		
		ConjuntoTDA aislados = g.vertices();
		
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int un_vertice = vertices.elegir();
			vertices.quitar(un_vertice);
			
			ConjuntoTDA verticesAux = g.vertices();
			while(!verticesAux.conjuntoVacio()) {
				
				int otro_vertice = verticesAux.elegir();
				verticesAux.quitar(otro_vertice);
				
				if(g.existeArista(un_vertice, otro_vertice) || g.existeArista(otro_vertice, un_vertice)) {
					aislados.quitar(un_vertice);
				}
			}
		}
		
		return aislados;	
	}
	
	/**
	 * Dado un Grafo G y dos v�rtices v1 y v2, escribir un m�todo que permita obtener el conjunto
		de todos los v�rtices puente entre v1 y v2.
		Se define que un v�rtice p es puente entre dos v�rtices o y d, si hay una arista que
		comienza en o y termina en p y otra que comienza en p y termina en d.
	 */
	public static ConjuntoTDA puentes(GrafoTDA g, int v1, int v2) {
		
		ConjuntoTDA puentes = new ConjuntoDinamico();
		ConjuntoTDA adyacentes = adyacentes(g, v1);
		
		while(!adyacentes.conjuntoVacio()) {
			
			int z = adyacentes.elegir();
			adyacentes.quitar(z);
			
			if(g.existeArista(z, v2)) {
				puentes.agregar(z);
			}
		}
		
		return puentes;
	}
}
