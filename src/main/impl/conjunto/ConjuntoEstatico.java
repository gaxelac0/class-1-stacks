package main.impl.conjunto;

import java.util.Arrays;

import main.interfaces.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
	
	private int[] elems;
	private int cant;
	
	public ConjuntoEstatico() {
		this.inicializarConjunto();
	}
	
	@Override
	public void inicializarConjunto() {
		elems = new int[10];
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
		int idx = 0;
		while(idx < cant && elems[idx] != x) 
			idx++;
		
		// lo piso con el ultimo y se reduce el indice
		// al reducir el indice el valor movido queda fuera del rango y no importa porque se pisara
		// cuando se inserte un nuevo valor.
		if(idx < cant) {
			elems[idx] = elems[cant-1];
			cant--;
		}
	}

	@Override
	public int elegir() {
		return elems[cant-1];
	}

	@Override
	public boolean pertenece(int x) {

		// recupero el indice
		int i = 0;
		while(i < cant && elems[i] != x) 
			i++;
	
		return i!=cant;
	}


	@Override
	public boolean conjuntoVacio() {
		return cant == 0;
	}

	@Override
	public String toString() {		
		return Arrays.toString(elems);
	}

}
