package main.impl.cola;

import main.interfaces.ColaTDA;

public class ColaEstatica implements ColaTDA {
	
	int[] a;
	int indice;
	
	public ColaEstatica() {
		this.inicializarCola();
	}

	@Override
	public void inicializarCola() {
		a = new int[10];
		indice = 0;
	}

	@Override
	public void acolar(int x) {
		a[indice] = x;
		indice++;
	}

	@Override
	public void desacolar() {
		// TODO check
		for(int i = 0; i <= indice; i++) {
			a[i] = a[i+1];
		}
		indice--;
	}

	@Override
	public int primero() {
		return a[0];
	}

	@Override
	public boolean colaVacia() {
		return indice == 0;
	}

}
