package main.impl.grafo;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.GrafoTDA;

public class GrafoDinamico implements GrafoTDA {
	
	class NodoGrafo {
		int v;
		NodoArista arista;
		NodoGrafo sigNodo;
	}
	
	class NodoArista {
		int peso;
		NodoArista sigArista;
		NodoGrafo nodoDestino;
	}
	
	NodoGrafo origen;
	
	@Override
	public void inicializarGrafo() {
		origen = null;
	}
	
	//------------------------------------------------------------------------------------//
	// Un nuevo nodo del grafo se agrega siempre al inicio.                               //
	// El nuevo nodo no tiene (inicialmente al menos) ninguna arista.                     //
	//------------------------------------------------------------------------------------//
	@Override
	public void agregarVertice(int x) {
		NodoGrafo nuevo = new NodoGrafo();	// El nuevo nodo se coloca al inicio
		nuevo.v = x;
		nuevo.arista = null;					// El nodo se agrega sin aristas inicialmente
		nuevo.sigNodo = origen;
		origen = nuevo;
	}
	
	//------------------------------------------------------------------------------------//
	// Este m�todo privado recibe un nodo y un v�rtice y elimina en ese nodo la arista    //
	// que tiene como destino el v�rtice "v". Si no hay ninguna arista apuntando a "v",   //
	// el m�todo termina sin hacer nada.                                                  //
	//------------------------------------------------------------------------------------//
	private void eliminarAristaEnNodo(NodoGrafo nodo, int v) {
		NodoArista aux = nodo.arista;
		if (aux != null) {
			if (aux.nodoDestino.v == v) {		// La arista que debe eliminarse es la primera
				nodo.arista = aux.sigArista;
			} else {								// La arista que debe eliminarse es otra
				while(aux.sigArista != null && aux.sigArista.nodoDestino.v != v)
					aux = aux.sigArista;
				if (aux.sigArista != null)			// Se encontr� la arista
					aux.sigArista = aux.sigArista.sigArista;
			}
		}
	}

	//------------------------------------------------------------------------------------//
	// Para eliminar un v�rtice, se lo elimina y se recorren todos los nodos para         //
	// eliminar todas las aristas que tengan el v�rtice por ser eliminado como destino.   //
	//------------------------------------------------------------------------------------//
	@Override
	public void eliminarVertice(int x) {
		if (origen.v == x)					// El primer v�rtice es el que debe eliminarse
			origen = origen.sigNodo;
		NodoGrafo aux = origen;				// Se define un nodo viajero
		while (aux != null) {					// El nodo "aux" recorre todos los v�rtices
			this.eliminarAristaEnNodo(aux, x);
			if (aux.sigNodo != null && aux.sigNodo.v == x) {
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
			aux = aux.sigNodo;
		}
	}

	//------------------------------------------------------------------------------------//
	// Este m�todo privado busca el nodo correspondiente al v�rtice "x" y lo devuelve     //
	// En caso de que no lo encuentre, devuelve "null".                                   //
	//------------------------------------------------------------------------------------//
	private NodoGrafo Vertice2Nodo(int x) {	// Devuelve el nodo del v�rtice o null 
		NodoGrafo aux = origen;
		while(aux !=null && aux.v != x)
			aux = aux.sigNodo;
		return aux;
	}
	
	//------------------------------------------------------------------------------------//
	// Para agregar una arista, se buscan ambos v�rtices involucrados y se agrega la      //
	// arista con el peso correspondiente. Se inserta la arista en la primera posici�n de //
	// la lista del nodo inicial.                                                         //                       //
	//------------------------------------------------------------------------------------//
	@Override
	public void agregarArista(int x, int y, int w) {
		NodoGrafo n1 = Vertice2Nodo(x);
		NodoGrafo n2 = Vertice2Nodo(y);
		NodoArista nuevo = new NodoArista();
		nuevo.peso = w;
		nuevo.nodoDestino = n2;
		nuevo.sigArista = n1.arista;
		n1.arista = nuevo;
	}
	
	//------------------------------------------------------------------------------------//
	// Para eliminar una arista, se busca el v�rtice inicial y se elimina la arista de    //
	// su lista de aristas.                                                               //
	//------------------------------------------------------------------------------------//
	@Override
	public void eliminarArista(int x, int y) {
		NodoGrafo nodo = Vertice2Nodo(x);
		eliminarAristaEnNodo(nodo, y);
	}

	//------------------------------------------------------------------------------------//
	// Para devolver el peso de una arista, se busca el v�rtice inicial y se devuelve el  //
	// peso de la arista correspondiente en su lista de aristas.                          //
	//------------------------------------------------------------------------------------//
	@Override
	public int pesoArista(int x, int y) {
		NodoGrafo nodo = Vertice2Nodo(x);
		NodoArista aux = nodo.arista;
		while (aux.nodoDestino.v != y)
			aux = aux.sigArista;
		return aux.peso;
	}

	//------------------------------------------------------------------------------------//
	// Para determinar la existencia de una arista, se la busca en la lista del nodo      //
	// inicial. Si la b�squeda es exitosa, se devuelve un nodo; si no, null.              //
	//------------------------------------------------------------------------------------//
	@Override
	public boolean existeArista(int x, int y) {
		NodoGrafo nodo = Vertice2Nodo(x);
		NodoArista aux = nodo.arista;
		while (aux != null && aux.nodoDestino.v != y)
			aux = aux.sigArista;
		return (aux != null);					// S�lo es null si no se encontr� la arista
	}

	@Override
	public ConjuntoTDA vertices() {
		ConjuntoTDA CNodos = new ConjuntoDinamico();
		CNodos.inicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null) {
			CNodos.agregar(aux.v);
			aux = aux.sigNodo;
		}
		return CNodos;
	}

}
