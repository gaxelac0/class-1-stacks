package main.impl;

import main.interfaces.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
	
	private int[] elems;
	private int cant;
	
	public ConjuntoEstatico() {
		this.inicializarConjunto();
	}
	
	@Override
	public void inicializarConjunto() {
		elems = new int[100];
		cant = 0;
	}

	@Override
	public void agregar(int x) {
		if(!pertenece(x)) {
			elems[cant] = x;
			cant++;
		}
	}
	
	// pisarlo con el ultimo y reducir indice
	@Override
	public void quitar(int x) {
		
		// obtengo el indice
		int i = 0;
		while(i < cant && elems[i] != x) 
			i++;
		
		if(i < cant) {
			elems[i] = elems[cant-1];
			cant--;
		}
	}

	@Override
	public int elegir() {
		return elems[cant-1];
	}

	/*
	 * si pertenece devuelve el indice, sino devuelve -1
	 */
	@Override
	public boolean pertenece(int x) {

		int i = 0;
		while(i < cant && elems[i] != x) 
			i++;
	
		return i!=cant;
	}


	@Override
	public boolean conjuntoVacio() {
		return cant == 0;
	}

}
