package main.impl.conjunto;

import main.interfaces.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {
	
	class Nodo {
		int valor;
		Nodo sig;
	}
	Nodo inicio;
	
	public ConjuntoDinamico() {
		this.inicializarConjunto();
	}

	@Override
	public void inicializarConjunto() {
		inicio = null;
	}

	@Override
	public void agregar(int x) {
		
		if(!pertenece(x)) {
			
			Nodo nuevo = new Nodo();
			nuevo.valor = x;
			nuevo.sig = inicio;
			inicio = nuevo;
		}
	}

	@Override
	public void quitar(int x) {
		
		if(inicio != null) {
			
			if(inicio.valor == x) {
				inicio = inicio.sig;
			}
			else {
				
				Nodo aux = inicio;
				while(aux.sig != null && aux.sig.valor != x) {
					aux = aux.sig;
				}
				
				if(aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
			}
		}
	}

	@Override
	public int elegir() {
		return inicio.valor;
	}

	@Override
	public boolean conjuntoVacio() {
		return (inicio==null);
	}

	@Override
	public boolean pertenece(int x) {
		
		Nodo aux = inicio;
		while(aux != null && aux.valor != x) {
			aux = aux.sig;
		}
		
		return (aux!=null);
	}

}
