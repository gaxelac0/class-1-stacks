package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.diccionario.*;
import main.impl.grafo.GrafoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioSimpleTDA;
import main.interfaces.GrafoTDA;
import main.utils.ConjuntoUtils;
import main.utils.GrafoUtils;

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
			
			if(g.existeArista(v, e)) {
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
	
	
	/**
	 * Dado un Grafo G escribir un método que permita obtener el conjunto de los vértices aislados
		en G.
		Se define que un vértice v es aislado si v no tiene aristas entrantes ni salientes.
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
	 * Dado un Grafo G y dos vértices v1 y v2, escribir un método que permita obtener el conjunto
		de todos los vértices puente entre v1 y v2.
		Se define que un vértice p es puente entre dos vértices o y d, si hay una arista que
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
	
	
	
	/**
	 * 3. (40 p) Dado un grafo , utilizare mos las siguientes definiciones:
		* Un vértice es inicial si no tiene aristas entrantes.
		* Un vértice es final si no tiene aristas salientes.
		* Un vértice está aislado si no tiene ni aristas entrantes ni ar istas salientes.
		Se pide:
		a) Escriba dos métodos, uno que devuelva el co njunto de vértices iniciales y otro que devuelva el conjunto de vértices fina les de un grafo G.
		b) ¿Cuál es el costo de sus métodos en términos de la cantidad de elementos del grafo?
		e) Explique cómo podrían aprovecharse los método~ ant: riores p~rn ?'.1-contrar el conjunto de nodos aislados de un gralo. De la exphcac1on
		solamente; no es necesario que escriba el código.
	 */
	public static void ejercicioFinalGrafos() {
		
		// Diagrama datos .\Diagramas\Grafos\ejercicio_final.png
		// vertices iniciales = 6, 7
		// vertices iniciales = 4, 8
		GrafoTDA g = new GrafoDinamico();
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarVertice(8);
		
		// los pesos son irrelevantes
		g.agregarArista(1, 2, -1);
		
		g.agregarArista(2, 1, -1);
		g.agregarArista(2, 3, -1);
		g.agregarArista(2, 4, -1);
		
		g.agregarArista(3, 5, -1);
		
		g.agregarArista(5, 4, -1);
		
		g.agregarArista(6, 1, -1);
		g.agregarArista(6, 8, -1);
		
		g.agregarArista(7, 4, -1);
		g.agregarArista(7, 8, -1);
		
		GrafoUtils.mostrarGrafo(g);
		
		ConjuntoTDA iniciales = iniciales(g);
		ConjuntoTDA finales = finales(g);
		
		System.out.print("Vertices iniciales: ");
		ConjuntoUtils.mostrarConjunto((ConjuntoDinamico)iniciales);
		
		System.out.print("Vertices iniciales: ");
		ConjuntoUtils.mostrarConjunto((ConjuntoDinamico)finales);
	}

	/**
	 * Recupera los vertices que son finales, son aquellos que tienen aristas entrantes pero no salientes.
	 * @param g
	 * @return
	 */
	public static ConjuntoTDA finales(GrafoTDA g) {
		
		ConjuntoTDA finales = g.vertices();
		
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int un_vertice = vertices.elegir();
			vertices.quitar(un_vertice);
			
			ConjuntoTDA verticesAux = g.vertices();
			while(!verticesAux.conjuntoVacio()) {
				
				int otro_vertice = verticesAux.elegir();
				verticesAux.quitar(otro_vertice);
				
				if(g.existeArista(un_vertice, otro_vertice)) {
					finales.quitar(un_vertice);
				}
			}
		}
		
		return finales;
	}

	/**
	 * Obtiene los vertices iniciales. Son aquellos que tienen aristas salientes pero no entrantes.
	 * @param g
	 * @return
	 */
	public static ConjuntoTDA iniciales(GrafoTDA g) {
		
		ConjuntoTDA iniciales = g.vertices();
		
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int un_vertice = vertices.elegir();
			vertices.quitar(un_vertice);
			
			ConjuntoTDA verticesAux = g.vertices();
			while(!verticesAux.conjuntoVacio()) {
				
				int otro_vertice = verticesAux.elegir();
				verticesAux.quitar(otro_vertice);
				
				if(g.existeArista(otro_vertice, un_vertice)) {
					iniciales.quitar(un_vertice);
				}
			}
		}
		
		return iniciales;
	}
	
	
	
	/**
	 * 3. (40p) Grafos y TDAs. Código y estrategia. Se tiene un grafo G. Se desea
	colocar parte de la información del grafo en un diccionario simple según
	la siguiente especificación:
	- Las claves del diccionario son los nodos del grafo.
	- El valor de cada clave es la suma de los pesos de sus aristas salientes. Si un nodo no 
	  tiene nodos aristas salientes, el valor correspondiente
	es 0.
	 */
	public static DiccionarioSimpleTDA convertirDictSimple(GrafoTDA g) {
		
		DiccionarioSimpleTDA d = new DiccionarioSimpleDinamico();
		
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int v = vertices.elegir();
			vertices.quitar(v);
			
			int peso_aristas_salientes_v = pesoAristasSalientes(g, v);
			d.agregar(v, peso_aristas_salientes_v);
		}
		
		return d;
	}

	/**
	 * obtiene la sumatoria de pesos de todas las aristas salientes de v.
	 * @param g grafo
	 * @param v vertice v
	 * @return suma de pesos de aristas salientes
	 */
	private static int pesoAristasSalientes(GrafoTDA g, int v) {
		
		int peso_salientes_v = 0;
		
		ConjuntoTDA vertices = g.vertices();
		while(!vertices.conjuntoVacio()) {
			
			int dest = vertices.elegir();
			vertices.quitar(dest);
			
			if(g.existeArista(v, dest)) {
				peso_salientes_v += g.pesoArista(v, dest);
			}
		}
		return peso_salientes_v;
	}
}
