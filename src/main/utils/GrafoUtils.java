package main.utils;

import main.impl.cola.ColaDinamica;
import main.impl.conjunto.ConjuntoDinamico;
import main.impl.pila.PilaDinamica;
import main.interfaces.ColaTDA;
import main.interfaces.ConjuntoTDA;
import main.interfaces.GrafoTDA;
import main.interfaces.PilaTDA;

public class GrafoUtils {
	
	public static void mostrarGrafo(GrafoTDA A) {
		ConjuntoTDA V1 = A.vertices();
		while (!V1.conjuntoVacio()) {
			int x1 = V1.elegir();
			V1.quitar(x1);
			ConjuntoTDA V2 = A.vertices();
			while (!V2.conjuntoVacio()) {
				int x2 = V2.elegir();
				V2.quitar(x2);
				if (A.existeArista(x1,x2))
					System.out.print(x1+"->("+A.pesoArista(x1,x2)+")->"+x2+" ");
				else
					System.out.print(x1+"->(0)->"+x2+" ");
			}
			System.out.println("");
		}
	}
	
	//---------------------------------------------------------------------------------------//
	// Este procedimiento muestra la secuencia de una búsqueda DFS (Depth-First Search) en   //
	// un grafo dirigido sin pesos. Para esto, se pusieron pesos ficticios 1 en las aristas. //
	// Los nodos pendientes se colocan en una pila.                                          //
	//---------------------------------------------------------------------------------------//
	public static void DFS (GrafoTDA G, int v) {
		PilaTDA Pendientes = new PilaDinamica();
		Pendientes.inicializarPila();
		ConjuntoTDA Visitados = new ConjuntoDinamico();
		Visitados.inicializarConjunto();
		
		Pendientes.apilar(v);
		Visitados.agregar(v);
		while(! Pendientes.pilaVacia()) {
			int actual = Pendientes.tope();
			System.out.print(actual+" ");
			Pendientes.desapilar();
			ConjuntoTDA Vertices = G.vertices();
			while (! Vertices.conjuntoVacio()) {
				int nodo = Vertices.elegir();
				Vertices.quitar(nodo);
				if (G.existeArista(actual, nodo) && ! Visitados.pertenece(nodo)) {
					Pendientes.apilar(nodo);
					Visitados.agregar(nodo);
				}
			}
		}
		System.out.println("");
	}
	
	//---------------------------------------------------------------------------------------//
	// Este procedimiento muestra la secuencia de una búsqueda BFS (Breadth-First Search)    //
	// en   un grafo dirigido sin pesos. Para esto, se pusieron pesos ficticios 1 en las     //
	// aristas. Los nodos pendientes se colocan en una cola.                                 //
	//---------------------------------------------------------------------------------------//
	public static void BFS (GrafoTDA G, int v) {
		ColaTDA Pendientes = new ColaDinamica();
		Pendientes.inicializarCola();
		ConjuntoTDA Visitados = new ConjuntoDinamico();
		Visitados.inicializarConjunto();
		Pendientes.acolar(v);
		Visitados.agregar(v);
		while(! Pendientes.colaVacia()) {
			int actual = Pendientes.primero();
			System.out.print(actual+" ");
			Pendientes.desacolar();
			ConjuntoTDA Vertices = G.vertices();
			while (! Vertices.conjuntoVacio()) {
				int nodo = Vertices.elegir();
				Vertices.quitar(nodo);
				if (G.existeArista(actual, nodo) && ! Visitados.pertenece(nodo)) {
					Pendientes.acolar(nodo);
					Visitados.agregar(nodo);
				}
			}
		}
		System.out.println("");
	}

}
