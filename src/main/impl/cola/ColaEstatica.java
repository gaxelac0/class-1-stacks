package main.impl.cola;

import main.interfaces.ColaTDA;

public class ColaEstatica implements ColaTDA {
	
	int[] a;
	int cant;
	
	public ColaEstatica() {
		this.inicializarCola();
	}

	@Override
	public void inicializarCola() {
		a = new int[10];
		cant = 0;
	}

	@Override
	public void acolar(int x) {
		a[cant] = x;
		cant++;
	}

	@Override
	public void desacolar() {
		for(int i = 0; i < cant; i++) {
			a[i] = a[i+1];
		}
		cant--;
	}

	@Override
	public int primero() {
		return a[0];
	}

	@Override
	public boolean colaVacia() {
		return cant == 0;
	}

}
