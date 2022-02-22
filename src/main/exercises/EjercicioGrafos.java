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


	/**
	 * Ejercicio TP6.4) resoluci�n por compa�ero TODO: revisar
	 * @param grafo
	 * @param vertice
	 * @return
	 */
	public static ConjuntoTDA DistanciaADos (GrafoTDA grafo, int vertice) {


		ConjuntoTDA ConjuntoGral = new ConjuntoDinamico();
		ConjuntoGral.inicializarConjunto();

		ConjuntoTDA ConjuntoVecinos = new ConjuntoDinamico();
		ConjuntoVecinos.inicializarConjunto();

		ConjuntoTDA ConjuntoAlcanzables = new ConjuntoDinamico();
		ConjuntoAlcanzables.inicializarConjunto();

		ConjuntoGral = grafo.vertices();

		while (!ConjuntoGral.conjuntoVacio()) {
			int aux = ConjuntoGral.elegir();

			if (grafo.existeArista(vertice, aux)){
				ConjuntoVecinos.agregar(aux);
				ConjuntoAlcanzables.agregar(aux);
			}
			ConjuntoGral.quitar(aux);
		}

		while (!ConjuntoVecinos.conjuntoVacio()) {
			ConjuntoGral = grafo.vertices();
			int auxVecino = ConjuntoVecinos.elegir();
			while (!ConjuntoGral.conjuntoVacio()) {
				int aux2 = ConjuntoGral.elegir();
				if (grafo.existeArista(auxVecino, aux2)){
					ConjuntoAlcanzables.agregar(aux2);	
				}
				ConjuntoGral.quitar(aux2);
			}
			ConjuntoVecinos.quitar(auxVecino);
		}	
		return ConjuntoAlcanzables;
	}

}
