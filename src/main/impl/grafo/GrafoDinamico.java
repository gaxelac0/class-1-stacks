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
	
	public GrafoDinamico() {
		this.inicializarGrafo();
	}

	@Override
	public void inicializarGrafo() {
		origen = null;
	}

	@Override
	public void agregarVertice(int valor) {

		NodoGrafo nuevo = new NodoGrafo();
		nuevo.v = valor;
		nuevo.sigNodo = origen;
		origen = nuevo;
	}

	@Override
	public void eliminarVertice(int valor) {
		
		if(origen.v == valor) {
			origen = origen.sigNodo;
			return;
		}
		
		NodoGrafo aux = origen;
		while(aux != null) {
			
			eliminarAristaEnNodo(aux, valor);
			if (aux.sigNodo != null && aux.sigNodo.v == valor) {
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
			aux = aux.sigNodo;
		}
	}

	@Override
	public void agregarArista(int v1, int v2, int peso) {
		
		NodoGrafo o = vertice2Nodo(v1);
		NodoGrafo d = vertice2Nodo(v1);

		NodoArista nueva = new NodoArista();
		nueva.peso = peso;
		nueva.nodoDestino = d;
		
		nueva.sigArista = o.arista;
		o.arista = nueva;
	}

	@Override
	public void eliminarArista(int v1, int v2) {
		
		NodoGrafo o = vertice2Nodo(v1);
		eliminarAristaEnNodo(o, v2);
	}

	@Override
	public ConjuntoTDA vertices() {

		ConjuntoTDA v = new ConjuntoDinamico();
		
		NodoGrafo aux = origen;
		while(aux != null) {
			v.agregar(aux.v);
			aux = aux.sigNodo;
		}

		return v;
	}

	@Override
	public boolean existeArista(int v1, int v2) {
		
		NodoGrafo o = vertice2Nodo(v1);
		NodoArista aux = o.arista;
		while(aux != null && aux.nodoDestino.v != v2) {
			aux = aux.sigArista;
		}
		
		return (aux!=null);
	}
	
	private NodoGrafo vertice2Nodo(int v) {
		
		NodoGrafo aux = origen;
		if(aux != null && aux.v != v) {
			aux = aux.sigNodo;
		}
		
		return aux;
	}
	
	/**
	 * Dado un NodoGrafo, eliminar la arista que tiene como origen destino igual a v.
	 * @param n NodoGrafo
	 * @param v valor del NodoGrafo destino
	 */
	private void eliminarAristaEnNodo(NodoGrafo n, int v) {
		
		NodoArista aux = n.arista;
		while(aux != null) {

			if(aux.nodoDestino.v == v) {
				aux = aux.sigArista;
			}
			else {
				
				while(aux.sigArista != null && aux.sigArista.nodoDestino.v != v) {
					aux = aux.sigArista;
				}
				
				if(aux.sigArista != null) {
					aux.sigArista = aux.sigArista.sigArista;
				}
			}	
		}
	}

	@Override
	public int pesoArista(int v1, int v2) {
		
		NodoGrafo o = vertice2Nodo(v1);
		NodoArista aux = o.arista;
		while(aux != null && aux.nodoDestino.v != v2) {
			aux = aux.sigArista;
		}

		return aux.peso;
	}

}
